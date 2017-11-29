package org.vibioh.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.handler.TextWebSocketHandler;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

@Component
public class EchoWebsocket extends TextWebSocketHandler {
    private static final Logger logger = Logger.getLogger(EchoWebsocket.class);

    @Override
    public void handleTextMessage(final WebSocketSession webSocketSession, final TextMessage webSocketMessage)
            throws Exception {
        webSocketSession.sendMessage(webSocketMessage);
    }
}
