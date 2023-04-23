package com.example.demo.changer;

import com.example.demo.data.entites.User;

import java.io.*;
import java.util.ArrayList;

public class FileChangerServiceUser {
    private final String filePath = "src/main/resources/entities/users/";


    private ArrayList<String> tempFile;
    public User find(String id) {
        try {
            File folder = new File("src/main/resources/entities/users");
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
            User user = new User();
            user.setId(Long.valueOf((tempFile.get(0))));
            user.setLogin(tempFile.get(1));
            user.setEmail(tempFile.get(2));
            user.setPassword(tempFile.get(3));
            user.setBalance(Integer.parseInt(tempFile.get(6)));
            user.setBasketId(Long.valueOf(tempFile.get(7)));
            return user;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new User();
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
