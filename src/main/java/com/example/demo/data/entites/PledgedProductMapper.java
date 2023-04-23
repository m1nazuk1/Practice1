package com.example.demo.data.entites;

import org.springframework.stereotype.Service;

@Service
public class PledgedProductMapper {
    public PledgedProduct map(String file) {
        PledgedProduct pledgedProduct = new PledgedProduct();

        pledgedProduct.setId(Long.valueOf(file.split("\n")[0]));
        return pledgedProduct;
    }
}
