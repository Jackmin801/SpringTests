package com.example.websocketdemo.Chat;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChatController {

    @GetMapping("/test")
    public Message test(){
        return new Message(true,"Hello World");
    }
}
