package com.example.demo.data;

import com.example.demo.data.entites.Entity;
import com.example.demo.data.entites.User;

public interface Datasource {
    Entity find(String paramName, String param);

    void write(Entity entity);

    void delete(String paramName, Long param);

    void change(Entity entity);
}
