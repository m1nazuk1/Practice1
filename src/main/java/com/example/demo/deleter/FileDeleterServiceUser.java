package com.example.demo.deleter;


import com.example.demo.data.entites.User;


import java.io.*;
import java.util.ArrayList;

public class FileDeleterServiceUser {
    private final String filePath = "src/main/resources/entities/users/";

    public void delete(Long id){
        File folder = new File(filePath + id + ".txt");

        folder.delete();
    }
}
