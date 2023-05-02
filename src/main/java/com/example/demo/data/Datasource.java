package com.example.demo.data;

import com.example.demo.data.entites.Entity;
import com.example.demo.data.entites.User;

import java.io.FileNotFoundException;

public interface Datasource {
    Entity find(String paramName, String param) throws FileNotFoundException;

    void write(Entity entity);

    void delete(String paramName, Long param);

    void change(Entity entity);
}
