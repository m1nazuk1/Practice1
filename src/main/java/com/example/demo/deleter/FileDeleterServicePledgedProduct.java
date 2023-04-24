package com.example.demo.deleter;

import java.io.File;

public class FileDeleterServicePledgedProduct {
    private final String filePath = "src/main/resources/entities/pledgedProduct/";

    public void delete(Long id){
        File folder = new File(filePath + id + ".txt");

        folder.delete();
    }
}
