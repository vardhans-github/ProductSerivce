package com.scaler.productservice.DTOs;

import com.scaler.productservice.models.Category;
import com.scaler.productservice.models.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateProductRequestDTO {
    private String title;
    private String description;
    private Double price;
    private String imageUrl;
    private int qty;
    private CategoryDTO categoryDTO;



    public Product convertToProduct() {
        Product product = new Product();

        product.setTitle(this.getTitle());
        product.setDescription(this.getDescription());
        product.setPrice(this.getPrice());
        product.setImageUrl(this.getImageUrl());

        if(product.getCategory() != null) {
            Category category1 = new Category();
            category1.setName(this.getCategoryDTO().getName());
            category1.setId(this.getCategoryDTO().getId());
            category1.setDescription(this.getCategoryDTO().getDescription());
            product.setCategory(category1);
        }
        return product;
    }


}
