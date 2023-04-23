package com.example.demo.changer;

import com.example.demo.data.entites.Product;

import java.io.*;
import java.util.ArrayList;

public class FileChangerServiceProduct {
    private final String filePath = "src/main/resources/entities/products/";

    private ArrayList<String> tempFile;
    public Product find(String id) {
        try {
            File folder = new File("src/main/resources/entities/products");
            File[] files = folder.listFiles();
            for (int i = 0; i < files.length; i++) {
                tempFile = new ArrayList<>();
                File file = files[i];
                FileReader fr = new FileReader(file);
                BufferedReader reader = new BufferedReader(fr);
                String line = reader.readLine();
                if (!line.equals(id)){
                    continue;
                }
                while (line != null) {
                    tempFile.add(line);
                    line = reader.readLine();
                }
                break;

            }
            Product product = new Product();
            product.setId(Long.valueOf(tempFile.get(0)));
            product.setName(tempFile.get(1));
            product.setPrice(Integer.parseInt(tempFile.get(2)));
            product.setDescription(tempFile.get(3));
            product.setImage(tempFile.get(4));
            return product;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new Product();
    }


    public void change(String text, String fileName) {

        try(FileWriter writer = new FileWriter(filePath + fileName + ".txt", false))
        {
            writer.write(text);
            writer.flush();
        }
        catch(IOException ex){
            ex.printStackTrace();
        }
    }
}
