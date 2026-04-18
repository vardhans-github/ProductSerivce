package com.scaler.productservice.services;

import com.scaler.productservice.DTOs.FakeStoreProductDTO;
import com.scaler.productservice.Exceptions.ProductNotFoundException;
import com.scaler.productservice.models.Category;
import com.scaler.productservice.models.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class FakeStoreServiceImpl implements ProductService {

    RestTemplate restTemplate = new RestTemplate();


    @Override
    public Product getProductById(long id) throws ProductNotFoundException {

        ResponseEntity<FakeStoreProductDTO> responseEntity =
                restTemplate.getForEntity(
                        "https://jsonplaceholder.typicode.com/todos/" + id,
                        FakeStoreProductDTO.class
                );

        FakeStoreProductDTO fakeStoreProductDto = responseEntity.getBody();

        if (fakeStoreProductDto == null) {
            throw new ProductNotFoundException(id, "Product not found, please pass a valid id.");
        }

        return from(fakeStoreProductDto);

    }

    @Override
    public List<Product> getAllProducts() {
        return List.of();
    }

    @Override
    public Product createProduct(Product product) {
        return null;
    }

    @Override
    public Product updateProduct(Long id, Product product) {
        return null;
    }

    @Override
    public void deleteProduct(Long id) {

    }

    private Product from(FakeStoreProductDTO fakeStoreProductDto) {
        if (fakeStoreProductDto != null) {
            Product product = new Product();
            product.setId(fakeStoreProductDto.getId());
            product.setTitle(fakeStoreProductDto.getTitle());
            product.setDescription(fakeStoreProductDto.getDescription());
            product.setPrice(fakeStoreProductDto.getPrice());
            product.setImageUrl(fakeStoreProductDto.getImage());

            Category category = new Category();
//            category.setTitle(fakeStoreProductDto.getCategory());
            product.setCategory(category);

            return product;
        }
        return null;
    }
}