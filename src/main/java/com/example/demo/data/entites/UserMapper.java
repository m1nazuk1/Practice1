package com.example.demo.data.entites;

import org.springframework.stereotype.Service;

@Service
public class UserMapper {
    public User map(String file) {
        User user = new User();

        user.setId(Long.valueOf(file.split("\n")[0]));
        return user;
    }
}
