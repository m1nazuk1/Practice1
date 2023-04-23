package com.example.demo.data.entites;

public enum Roles {
    ADMIN("ADMIN"), SIMPLE_USER("SIMPLE_USER");

    private final String name;

    Roles(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
