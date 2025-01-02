package com.Collaborative.DSALearningPlatform.Configurations;

import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

/**
 * WebSocket handler for the code editor.
 * This class manages WebSocket connections and handles text messages 
 * sent by connected clients in the code editor feature.
 */
public class CodeEditorWebSocketHandler extends TextWebSocketHandler {

    /**
     * Handles incoming text messages from WebSocket clients.
     * 
     * @param session the WebSocket session of the client sending the message.
     * @param message the text message received from the client.
     */
    @Override
    public void handleTextMessage(WebSocketSession session, org.springframework.web.socket.TextMessage message) {
        // Logic to handle and process incoming messages.
        // In this example, the server echoes back the received message to the client.

        try {
            // Send a response back to the client confirming receipt of the message.
            session.sendMessage(new org.springframework.web.socket.TextMessage("Received: " + message.getPayload()));
        } catch (Exception e) {
            // Log the exception for debugging and monitoring purposes.
            e.printStackTrace();
        }
    }
}
