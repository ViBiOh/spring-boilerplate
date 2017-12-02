package org.vibioh.controller;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@Component
public class EchoWebsocket extends TextWebSocketHandler {
    @Override
    public void handleTextMessage(final WebSocketSession webSocketSession, final TextMessage webSocketMessage)
            throws Exception {
        webSocketSession.sendMessage(webSocketMessage);
    }
}
