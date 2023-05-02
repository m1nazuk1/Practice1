package com.example.demo.data.entites;

import org.springframework.stereotype.Service;

@Service
public class PledgeMapper {
    public Pledge map(String file) {
        Pledge pledge = new Pledge();

        pledge.setId(Long.valueOf(file.split("\n")[0]));
        return pledge;
    }
}