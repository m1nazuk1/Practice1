package com.example.demo.data.entites;

import com.example.demo.Writers.FileWriterServicePledgedProduct;

import com.example.demo.data.Datasource;
import com.example.demo.deleter.FileDeleterServicePledgedProduct;
import org.springframework.stereotype.Component;


@Component
public class PledgedProductDatasource implements Datasource {
    private FileWriterServicePledgedProduct fileWriter = new FileWriterServicePledgedProduct();
    private FileDeleterServicePledgedProduct fileDeleter = new FileDeleterServicePledgedProduct();

    @Override
    public PledgedProduct find(String paramName, String param) {
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