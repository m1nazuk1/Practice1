package com.example.demo.data.entites;

import com.example.demo.Writers.FileWriterServicePledge;
import com.example.demo.Writers.FileWriterServicePledgedProduct;
import com.example.demo.allPrint.DisplayAllPledgedProducts;
import com.example.demo.data.Datasource;
import com.example.demo.deleter.FileDeleterServicePledge;
import com.example.demo.deleter.FileDeleterServicePledgedProduct;
import org.springframework.stereotype.Component;

import java.io.FileNotFoundException;


@Component
public class PledgeDatasource implements Datasource {
    private FileWriterServicePledge fileWriter = new FileWriterServicePledge();
    private FileDeleterServicePledge fileDeleter = new FileDeleterServicePledge();

    @Override
    public Pledge find(String paramName, String param) throws FileNotFoundException {
        return fileWriter.find(param);
    }

    @Override
    public void write(Entity entity) {
        fileWriter.write(entity.getId() + "");
    }

    @Override
    public void delete(String paramName, Long param) {fileDeleter.delete(param);}

    @Override
    public void change(Entity entity){fileWriter.write(entity.getId() + "");}
}