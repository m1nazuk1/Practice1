package com.example.demo.Writers;

import com.example.demo.allPrint.DisplayAllPledgedProducts;
import com.example.demo.data.entites.Pledge;
import com.example.demo.data.entites.PledgedProduct;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class FileWriterServicePledge {
    private final String filePath = "src/main/resources/entities/pledge/";
    private ArrayList<String> tempFile;

    public Pledge find(String id) throws FileNotFoundException {
        try {
            File folder = new File("src/main/resources/entities/pledge");
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
            Pledge pledge = new Pledge();
            pledge.setId(Long.valueOf(tempFile.get(0)));
            return pledge;
        } catch (
                FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new Pledge();
    }


    public void write(String fileName) {
        String text = fileName + "\n" + LocalDate.now() + "\n" + LocalDate.now().plusMonths(3);

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
