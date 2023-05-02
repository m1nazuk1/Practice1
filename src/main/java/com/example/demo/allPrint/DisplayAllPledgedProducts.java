package com.example.demo.allPrint;

import com.example.demo.data.entites.PledgedProduct;
import com.example.demo.data.entites.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DisplayAllPledgedProducts {
    private final String filePath = "src/main/resources/entities/pledgedProducts/";
    private static ArrayList<String> tempFile;
    public static List<PledgedProduct> getPledgedProducts() throws FileNotFoundException {
        try {
            File folder = new File("src/main/resources/entities/pledgedProducts");
            File[] files = folder.listFiles();
            List<PledgedProduct> pledgedProducts = new ArrayList<>();
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
                PledgedProduct pledgedProduct = new PledgedProduct();
                pledgedProduct.setId(Long.valueOf(tempFile.get(0)));
                pledgedProduct.setName(tempFile.get(1));
                pledgedProduct.setPrice(Integer.parseInt(tempFile.get(2)));
                pledgedProduct.setDescription(tempFile.get(3));
                pledgedProduct.setImage(tempFile.get(4));
                pledgedProducts.add(pledgedProduct);
            }
            return pledgedProducts;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
