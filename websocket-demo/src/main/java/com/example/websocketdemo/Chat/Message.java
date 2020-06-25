package com.example.websocketdemo.Chat;

import java.time.LocalDateTime;

public class Message {
    private boolean byMe;
    private String msgText;
    private LocalDateTime timestamp;

    public Message(boolean byMe, String msgText) {
        this.byMe = byMe;
        this.msgText = msgText;
        this.timestamp = LocalDateTime.now();
    }

    public boolean isByMe() {
        return byMe;
    }

    public String getMsgText() {
        return msgText;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }
}
