package com.example.demo.changer;

import com.example.demo.data.entites.PledgedProduct;

import java.io.*;
import java.util.ArrayList;

public class FileChangerServicePledgedProduct {
    private final String filePath = "src/main/resources/entities/pledgedProducts/";
    private ArrayList<String> tempFile;

    public PledgedProduct find(String id) {
        try {
            File folder = new File("src/main/resources/entities/pledgedProducts");
            File[] files = folder.listFiles();
            for (int i = 0; i < files.length; i++) {
                tempFile = new ArrayList<>();
                File file = files[i];
                FileReader fr = new FileReader(file);
                BufferedReader reader = new BufferedReader(fr);
                String line = reader.readLine();
                if (!line.equals(id)) {
                    continue;
                }
                while (line != null) {
                    tempFile.add(line);
                    line = reader.readLine();
                }
                break;

            }
            PledgedProduct pledgedProduct = new PledgedProduct();
            pledgedProduct.setId(Long.valueOf(tempFile.get(0)));
            pledgedProduct.setName(tempFile.get(1));
            pledgedProduct.setPrice(Integer.parseInt(tempFile.get(2)));
            pledgedProduct.setDescription(tempFile.get(3));
            pledgedProduct.setImage(tempFile.get(4));
            return pledgedProduct;
        } catch (
                FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new PledgedProduct();
    }


    public void change(String text, String fileName) {

        try (FileWriter writer = new FileWriter(filePath + fileName + ".txt", false))
        {
            writer.write(text);
            writer.flush();
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
