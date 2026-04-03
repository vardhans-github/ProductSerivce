package com.scaler.productservice.controllers;


import com.scaler.productservice.Exceptions.ProductNotFoundException;
import com.scaler.productservice.models.Product;
import com.scaler.productservice.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }


    @GetMapping("/hello")
    public  String sayHello(){
        return "dthd";
    }


    @GetMapping("/{productId}")
    public  String sayHello(@PathVariable("productId") Long productId){
        try{
            Product product = productService.getProductById(productId);
            return product.toString();
        }
        catch(ProductNotFoundException e){
            System.out.print(e.getMessage());
        }
        return null;
    }

}
