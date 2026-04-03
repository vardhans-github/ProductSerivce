package com.scaler.productservice.Exceptions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductNotFoundException extends Exception {
    private Long productId;
    private String message;

    public ProductNotFoundException(Long productId, String message) {
        super(message);
        this.productId = productId;
    }
}