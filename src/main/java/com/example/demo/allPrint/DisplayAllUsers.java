package com.example.demo.allPrint;

import com.example.demo.data.entites.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class DisplayAllUsers {
    private final String filePath = "src/main/resources/entities/users/";
    private ArrayList<String> tempFile;
    public List<User> getUsers() throws FileNotFoundException {
        try {
            File folder = new File("src/main/resources/entities/users");
            File[] files = folder.listFiles();
            List<User> users = new ArrayList<>();
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
                User user = new User();
                user.setId(Long.valueOf((tempFile.get(0))));
                user.setLogin(tempFile.get(1));
                user.setEmail(tempFile.get(2));
                user.setPassword(tempFile.get(3));
                user.setBalance(Integer.parseInt(tempFile.get(6)));
                user.setBasketId(Long.valueOf(tempFile.get(7)));
                users.add(user);
            }
            return users;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
