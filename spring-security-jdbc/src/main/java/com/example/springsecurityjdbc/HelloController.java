package com.example.springsecurityjdbc;

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
}
