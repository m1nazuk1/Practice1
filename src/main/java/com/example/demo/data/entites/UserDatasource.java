package com.example.demo.data.entites;

import com.example.demo.Writers.FileWriterServiceUser;
import com.example.demo.allPrint.DisplayAllUsers;
import com.example.demo.data.Datasource;
import com.example.demo.deleter.FileDeleterServiceUser;
import org.springframework.stereotype.Component;

import java.io.FileNotFoundException;
import java.util.List;

@Component
public class UserDatasource implements Datasource {

    private FileWriterServiceUser fileWriter = new FileWriterServiceUser();
    private FileDeleterServiceUser fileDeleter = new FileDeleterServiceUser();
    private DisplayAllUsers displayUsers = new DisplayAllUsers();

    @Override
    public User find(String paramName, String param) {
        return fileWriter.find(param);
    }

    @Override
    public void write(Entity entity) {
        fileWriter.write(entity.write(), entity.getId() + "");
    }

    @Override
    public void delete(String paramName, Long param) {fileDeleter.delete(param);}

    public List<User> getUsers() throws FileNotFoundException {return displayUsers.getUsers();}

    @Override
    public void change(Entity entity){fileWriter.write(entity.write(), entity.getId() + "");}

    public Boolean auf(String login, String password){return fileWriter.auf(login, password);}
}
