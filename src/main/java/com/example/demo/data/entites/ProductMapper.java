package com.example.demo.data.entites;

import org.springframework.stereotype.Service;

@Service
public class ProductMapper {
    public Product map(String file) {
        Product product = new Product();

        product.setId(Long.valueOf(file.split("\n")[0]));
        return product;
    }
}