package com.scaler.productservice.DTOs;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakeStoreProductDTO {
    private Long id;
    private String title;
    private String description;
    private double price;
    private String category;
    private String image;
}
