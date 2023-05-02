package com.example.demo.allPrint;

import com.example.demo.data.entites.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DisplayAllProduct {
    private final String filePath = "src/main/resources/entities/products/";
    private ArrayList<String> tempFile;
    public List<Product> getProducts() throws FileNotFoundException {
        try {
            File folder = new File("src/main/resources/entities/products");
            File[] files = folder.listFiles();
            List<Product> products = new ArrayList<>();
            for (int i = 0; i < files.length; i++) {
                tempFile = new ArrayList<>();
                File file = files[i];
                FileReader fr = new FileReader(file);
                BufferedReader reader = new BufferedReader(fr);
                String line = reader.readLine();
                while (line != null) {
                    tempFile.add(line);
                    line = reader.readLine();
                }
                Product product = new Product();
                product.setId(Long.valueOf(tempFile.get(0)));
                product.setName(tempFile.get(1));
                product.setPrice(Integer.parseInt(tempFile.get(2)));
                product.setDescription(tempFile.get(3));
                product.setImage(tempFile.get(4));
                products.add(product);
            }
            return products;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
