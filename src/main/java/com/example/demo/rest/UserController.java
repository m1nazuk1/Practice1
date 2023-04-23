package com.example.demo.rest;

import com.example.demo.Writers.FileWriterServiceUser;
import com.example.demo.data.entites.User;
import com.example.demo.data.entites.UserDatasource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/api/users")
@RestController
public class UserController {
    @GetMapping("/getAllUsers")
    public List<User> getUsers(){

        return null;
    }
}
