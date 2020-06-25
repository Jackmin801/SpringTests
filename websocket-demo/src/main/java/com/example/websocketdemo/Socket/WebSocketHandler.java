package com.example.websocketdemo.Socket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.socket.*;
import org.springframework.web.socket.handler.AbstractWebSocketHandler;

import java.util.ArrayList;

@Controller
public class WebSocketHandler extends AbstractWebSocketHandler {
    @Autowired
    SocketService socketService;

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        String[] words = message.getPayload().split(" ");
        switch(words[0]){
            case "CLAIM":
                if(socketService.claimSocket(session,words[1])){
                    System.out.println(words[1]+" claims "+session.getId());
                }
                break;
            case "TYPING":
                break;
            case "MSG":
                socketService.getUsersSocket(words[1]).sendMessage(message);
        }
    }

    @Override
    protected void handleBinaryMessage(WebSocketSession session, BinaryMessage message) throws Exception {
        System.out.println("New Binary Received");
        session.sendMessage(message);
    }

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        System.out.println(session.getId()+" has connected, awaiting claim...");
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        System.out.println(session.getId() +" has disconnected");
        socketService.closeSocket(session.getId());
    }
}
