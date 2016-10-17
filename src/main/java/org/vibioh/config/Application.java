package org.vibioh.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Bean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@Configuration
@EnableAutoConfiguration
@EnableWebSocket
@ComponentScan(value = "org.vibioh")
@PropertySource("classpath:application.properties")
public class Application implements WebSocketConfigurer {
    @Autowired
    private WebSocketHandler webSocketHandler;

    @Override
    public void registerWebSocketHandlers(final WebSocketHandlerRegistry webSocketHandlerRegistry) {
        webSocketHandlerRegistry.addHandler(webSocketHandler, "/ws/hello");

        webSocketHandlerRegistry
                .addHandler(webSocketHandler, "/ws/hello")
                .withSockJS();
    }

    @Bean
    public Clock clock() {
        return Clock.systemUTC();
    }

    public static void main(final String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }
}
