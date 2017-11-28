package org.vibioh.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;

@Component
public class EchoWebsocket implements WebSocketHandler {
    private static final Logger logger = Logger.getLogger(EchoWebsocket.class);

    @Override
    public void afterConnectionEstablished(final WebSocketSession webSocketSession) throws Exception {
        logger.info("afterConnectionEstablished");
    }

    @Override
    public void handleMessage(final WebSocketSession webSocketSession, final WebSocketMessage<?> webSocketMessage)
            throws Exception {
        webSocketSession.sendMessage(webSocketMessage);
    }

    @Override
    public void handleTransportError(final WebSocketSession webSocketSession, final Throwable throwable)
            throws Exception {
        logger.error("handleTransportError", throwable);
    }

    @Override
    public void afterConnectionClosed(final WebSocketSession webSocketSession, final CloseStatus closeStatus)
            throws Exception {
        logger.info("afterConnectionClosed Status : " + closeStatus);
    }

    @Override
    public boolean supportsPartialMessages() {
        return false;
    }
}
