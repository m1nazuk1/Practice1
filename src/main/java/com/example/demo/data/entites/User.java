package com.example.demo.data.entites;

import lombok.Data;

import java.util.ArrayList;

@Data
public class User implements com.example.demo.data.entites.Entity
{
    private Long id;
    private String login;
    private String email;
    private String password;
    private ArrayList<com.example.demo.data.entites.Roles> roles;
    private ArrayList<com.example.demo.data.entites.Pledge> pledges;
    private int balance;
    private Long basketId;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public String write() {
        StringBuilder writeInFile = new StringBuilder();
        writeInFile.append(getId());
        writeInFile.append("\n");
        writeInFile.append(getLogin());
        writeInFile.append("\n");
        writeInFile.append(getEmail());
        writeInFile.append("\n");
        writeInFile.append(getPassword());
        writeInFile.append("\n");
        writeInFile.append(getRoles());
        writeInFile.append("\n");
        writeInFile.append(getPledges());
        writeInFile.append("\n");
        writeInFile.append(getBalance());
        writeInFile.append("\n");
        writeInFile.append(getBasketId());
        return writeInFile.toString();
    }

    @Override
    public String change() {
        StringBuilder writeInFile = new StringBuilder();
        writeInFile.append(getId());
        writeInFile.append("\n");
        writeInFile.append(getLogin());
        writeInFile.append("\n");
        writeInFile.append(getEmail());
        writeInFile.append("\n");
        writeInFile.append(getPassword());
        writeInFile.append("\n");
        writeInFile.append(getRoles());
        writeInFile.append("\n");
        writeInFile.append(getPledges());
        writeInFile.append("\n");
        writeInFile.append(getBalance());
        writeInFile.append("\n");
        writeInFile.append(getBasketId());
        return writeInFile.toString();
    }

    @Override
    public void delete(){

    }

    @Override
    public String toString() {
        return "User{" +
                "Id=" + id +
                ", login='" + login + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", roles=" + roles +
                ", pledges=" + pledges +
                ", balance=" + balance +
                ", basketId=" + basketId +
                '}';
    }

}