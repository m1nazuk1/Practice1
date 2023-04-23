package com.example.demo.data.entites;

import com.example.demo.Writers.FileWriterServiceProduct;
import com.example.demo.data.Datasource;
import com.example.demo.deleter.FileDeleterServiceProduct;
import com.example.demo.deleter.FileDeleterServiceUser;
import org.springframework.stereotype.Component;

@Component
public class ProductDatasource implements Datasource {

    private FileWriterServiceProduct fileWriter = new FileWriterServiceProduct();
    private FileDeleterServiceProduct fileDeleter = new FileDeleterServiceProduct();

    @Override
    public Product find(String paramName, String param) {
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