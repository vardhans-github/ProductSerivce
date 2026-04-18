package com.scaler.productservice.controllers;


import com.scaler.productservice.DTOs.CreateProductRequestDTO;
import com.scaler.productservice.DTOs.ProductDTO;
import com.scaler.productservice.Exceptions.ProductNotFoundException;
import com.scaler.productservice.models.Product;
import com.scaler.productservice.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    public ProductController(ProductService productService)
    {
        this.productService = productService;
    }


    @GetMapping("/hello")
    public  String sayHello(){
        return "sbfdbfs ";
    }


    @PostMapping
    public Product createProduct(@RequestBody CreateProductRequestDTO requestDTO){
        Product product;
        try{
            product = productService.createProduct(requestDTO.convertToProduct());
        }
        catch(Exception e){
            product = null;
        }
        return product;
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<ProductDTO> getProductById(@PathVariable Long id){
        if(id < 0){
            throw new IllegalArgumentException("Product id cannot be negative");
        }else if(id == 0){
            throw new IllegalArgumentException("Product id cannot be zero");
        }

        Product product = null;
        try {
            product = productService.getProductById(id);
        } catch (ProductNotFoundException e) {
            throw new ProductNotFoundException(id, "ff");
        }

        if(product == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }



        ProductDTO productDTO = product.convert();

        return new ResponseEntity<>(productDTO,HttpStatus.OK);
    }



}
