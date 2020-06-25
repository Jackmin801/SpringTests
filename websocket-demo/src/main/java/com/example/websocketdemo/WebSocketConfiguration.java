package com.example.websocketdemo;

import com.example.websocketdemo.Socket.WebSocketHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import org.springframework.web.socket.server.standard.ServletServerContainerFactoryBean;

import javax.servlet.ServletContext;
import javax.websocket.server.ServerContainer;

@Configuration
@EnableWebSocket
public class WebSocketConfiguration implements WebSocketConfigurer {
    /*
    @Autowired
    private ServletContext servletContext;
    private boolean ignoreNullWsContainer;

    @Bean
    public ServletServerContainerFactoryBean createWebSocketContainer() {

        // Check if null-container is allowed to prevent Exceptions
        if (ignoreNullWsContainer) {
            // Check if attribute is set in the ServletContext
            ServerContainer serverContainer = (ServerContainer) this.servletContext.getAttribute("javax.websocket.server.ServerContainer");
            if (serverContainer == null) {
                System.out.println("Could not initialize Websocket Container in Testcase.");
                return null;
            }
        }

        ServletServerContainerFactoryBean container = new ServletServerContainerFactoryBean();
        container.setMaxBinaryMessageBufferSize(1024000);
        return container;
    }

    @Value("${project.ignore-null-websocket-container}")
    private void setIgnoreNullWsContainer(String flag) {
        this.ignoreNullWsContainer = Boolean.parseBoolean(flag);
    }
    */

    @Bean
    public ServletServerContainerFactoryBean createWebSocketContainer(){
        ServletServerContainerFactoryBean container = new ServletServerContainerFactoryBean();
        container.setMaxBinaryMessageBufferSize(1024000);
        return container;
    }

    @Autowired
    public WebSocketHandler webSocketHandler;

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler( webSocketHandler , "/socket").setAllowedOrigins("*");
    }
}
