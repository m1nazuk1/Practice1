package com.example.demo.data.entites;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Pledge implements com.example.demo.data.entites.Entity{

    private Long id;
    private LocalDate dateNow = LocalDate.now();
    private LocalDate dateAfter = dateNow.plusMonths(3);

    @Override
    public Long getId() {
        return id;
    }


    @Override
    public String write() {
        StringBuilder writeInFile = new StringBuilder();
        writeInFile.append(getId());
        writeInFile.append("\n");
        writeInFile.append(getDateNow());
        writeInFile.append("\n");
        writeInFile.append(getDateAfter());
        return writeInFile.toString();
    }

    @Override
    public String change() {
        StringBuilder writeInFile = new StringBuilder();
        writeInFile.append(getId());
        writeInFile.append("\n");
        writeInFile.append(getDateNow());
        writeInFile.append("\n");
        writeInFile.append(getDateAfter());
        return writeInFile.toString();
    }

    @Override
    public void delete() {

    }

    @Override
    public String toString() {
        return "Pledge{" +
                "id=" + id +
                ", dateNow=" + dateNow +
                ", dateAfter=" + dateAfter +
                '}';
    }
}
