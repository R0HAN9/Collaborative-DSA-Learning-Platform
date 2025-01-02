package com.Collaborative.DSALearningPlatform.Configurations;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

/**
 * Configuration class for WebSocket support in the Collaborative DSA Learning Platform.
 * This class sets up WebSocket handlers for enabling real-time features.
 */
@Configuration
@EnableWebSocket // Enables WebSocket support in the Spring application
public class WebSocketConfig implements WebSocketConfigurer {

    /**
     * Registers WebSocket handlers for handling WebSocket connections.
     * 
     * @param registry the registry for adding WebSocket handlers.
     */
    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        // Registers a WebSocket handler for the "/editor" endpoint.
        // This handler manages real-time collaboration in the code editor feature.
        registry.addHandler(new CodeEditorWebSocketHandler(), "/editor");
    }
}
