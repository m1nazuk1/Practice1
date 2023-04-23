package com.example.demo.data.entites;

import lombok.Data;

@Data
public class Product implements com.example.demo.data.entites.Entity {
    private Long id;
    private String name;
    private int price;
    private String description;
    private String image;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public String write() {
        StringBuilder writeInFile = new StringBuilder();
        writeInFile.append(getId());
        writeInFile.append("\n");
        writeInFile.append(getName());
        writeInFile.append("\n");
        writeInFile.append(getPrice());
        writeInFile.append("\n");
        writeInFile.append(getDescription());
        writeInFile.append("\n");
        writeInFile.append(getImage());
        return writeInFile.toString();
    }

    @Override
    public String change() {
        StringBuilder writeInFile = new StringBuilder();
        writeInFile.append(getId());
        writeInFile.append("\n");
        writeInFile.append(getName());
        writeInFile.append("\n");
        writeInFile.append(getPrice());
        writeInFile.append("\n");
        writeInFile.append(getDescription());
        writeInFile.append("\n");
        writeInFile.append(getImage());
        return writeInFile.toString();
    }

    @Override
    public void delete() {

    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", image='" + image + '\'' +
                '}';
    }
}