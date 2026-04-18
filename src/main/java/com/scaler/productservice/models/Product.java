package com.scaler.productservice.models;

import com.scaler.productservice.DTOs.CategoryDTO;
import com.scaler.productservice.DTOs.ProductDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "products")
public class Product extends BaseModel{
    private String title;
    private String description;
    private Double price;
    private String imageUrl;
    private int qty;
    @ManyToOne
    private Category category;

    public ProductDTO convert(){
        ProductDTO productDto = new ProductDTO();
        productDto.setId(this.getId());
        productDto.setDescription(this.getDescription());
        productDto.setPrice(this.getPrice());
        productDto.setImageUrl(this.getImageUrl());
        if(this.getCategory() != null) {
            CategoryDTO categoryDto = new CategoryDTO();
            categoryDto.setName(this.getCategory().getName());
            categoryDto.setId(this.getCategory().getId());
            categoryDto.setDescription(this.getCategory().getDescription());
            productDto.setCategory(categoryDto);
        }
        return productDto;

    }
}
