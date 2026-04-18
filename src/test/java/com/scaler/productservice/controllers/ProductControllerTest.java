package com.scaler.productservice.controllers;

import com.scaler.productservice.DTOs.ProductDTO;
import com.scaler.productservice.Exceptions.ProductNotFoundException;
import com.scaler.productservice.models.Product;
import com.scaler.productservice.services.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
class ProductControllerTest {

    @Autowired
    ProductController productController;

    @MockitoBean
    ProductService productService;

    @Test
    public void TestGetProductById_WithValidId_RunSuccfully() throws ProductNotFoundException {
        Product product = new Product();
        product.setTitle("Tit le");
        product.setQty(3);
        product.setId(1l);
        product.setPrice(499.99);
        product.setDescription("lorem disription");

        when(productService.getProductById(1l)).thenReturn(product);

        ResponseEntity<ProductDTO> responseProduct =  productController.getProductById(1l);

        assertNotNull(responseProduct);
        assertNotNull(responseProduct.getBody());
        assertEquals(1L, responseProduct.getBody().getId());
        assertEquals("lorem disription", responseProduct.getBody().getDescription());
        verify(productService, times(1)).getProductById(1l);

    }

}