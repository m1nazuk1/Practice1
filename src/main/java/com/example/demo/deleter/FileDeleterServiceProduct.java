package com.example.demo.deleter;

import java.io.File;

public class FileDeleterServiceProduct {
    private final String filePath = "src/main/resources/entities/products/";

    public void delete(Long id) {
        File folder = new File(filePath + id + ".txt");

        folder.delete();
    }
}
