package com.example.demo.data.entites;

import com.example.demo.Writers.FileWriterServiceUser;
import com.example.demo.data.Datasource;
import com.example.demo.deleter.FileDeleterServiceUser;
import org.springframework.stereotype.Component;

@Component
public class UserDatasource implements Datasource {

    private FileWriterServiceUser fileWriter = new FileWriterServiceUser();
    private FileDeleterServiceUser fileDeleter = new FileDeleterServiceUser();

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

    @Override
    public void change(Entity entity){fileWriter.write(entity.write(), entity.getId() + "");}
}
