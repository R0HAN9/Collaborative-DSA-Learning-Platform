package com.Collaborative.DSALearningPlatform.Configurations;

import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class CodeEditorWebSocketHandler extends TextWebSocketHandler {

    @Override
    public void handleTextMessage(WebSocketSession session, org.springframework.web.socket.TextMessage message) {
        // Logic to broadcast code updates to all connected clients
        // For simplicity, let's just echo the received message
        try {
            session.sendMessage(new org.springframework.web.socket.TextMessage("Received: " + message.getPayload()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
