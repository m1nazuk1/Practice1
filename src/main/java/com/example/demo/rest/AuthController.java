package com.example.demo.rest;


import com.example.demo.data.entites.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private UserDatasource userDatasource;

    @Autowired
    private ProductDatasource productDatasource;

    @Autowired
    private PledgedProductDatasource pledgedProductDatasource;

    @PostMapping("/register")
    public void register(@RequestBody User user) {
        userDatasource.write(user);
    }

    @PostMapping("/setProduct")
    public void setProduct(@RequestBody Product product) {
        productDatasource.write(product);
    }

    @PostMapping("/setPledgedProduct")
    public void setPledgedProduct(@RequestBody PledgedProduct pledgedProduct) {pledgedProductDatasource.write(pledgedProduct);}

    @GetMapping("/getUser")
    public User getUser(@Param("id") String id) {
        return userDatasource.find("id", id);
    }

    @GetMapping("/getPledgedProduct")
    public PledgedProduct getPledgedProduct(@Param("id") String id){ return pledgedProductDatasource.find("id", id); };

    @GetMapping("/getProduct")
    public Product getProduct(@Param("id") String id){ return productDatasource.find("id", id); };

    @DeleteMapping("/deleteUser")
    public void deleteUser(@Param("id") Long id){userDatasource.delete("id", id);}

    @DeleteMapping("/deleteProduct")
    public void deleteProduct(@Param("id") Long id){productDatasource.delete("id", id);}

    @DeleteMapping("/deletePledgedProduct")
    public void deletePledgedProduct(@Param("id") Long id){pledgedProductDatasource.delete("id", id);}

    @PutMapping("/changeUser")
    public void changeUser(@RequestBody User user){userDatasource.change(user);}

    @PutMapping("/changeProduct")
    public void changeProduct(@RequestBody Product product){productDatasource.change(product);}

    @PutMapping("/changePledgedProduct")
    public void changePledgedProduct(@RequestBody PledgedProduct pledgedProduct){pledgedProductDatasource.change(pledgedProduct);}

}
