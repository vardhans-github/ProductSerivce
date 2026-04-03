package com.scaler.productservice.services;

import com.scaler.productservice.Exceptions.ProductNotFoundException;
import com.scaler.productservice.models.Product;

import java.util.List;

public interface ProductService {
    Product getProductById(long id) throws ProductNotFoundException;

    List<Product> getAllProducts();

    Product createProduct(Product product);

    Product updateProduct(Long id, Product product);

    void deleteProduct(Long id);
}