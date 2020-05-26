package com.example.securitytest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/")
    public  String hello(){
        return "Hello world";
    }

    @GetMapping("/user")
    public String hiUser(){return "Hello User";}

    @GetMapping("/admin")
    public String hiAdmin(){return "Hello Admin";}

    @GetMapping("/hello")
    public String hi(){
        return "Hello Boii";
    }
}
