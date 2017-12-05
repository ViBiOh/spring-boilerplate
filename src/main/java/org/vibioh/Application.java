package org.vibioh;

import com.mangofactory.swagger.configuration.SpringSwaggerConfig;
import com.mangofactory.swagger.models.dto.ApiInfo;
import com.mangofactory.swagger.plugin.EnableSwagger;
import com.mangofactory.swagger.plugin.SwaggerSpringMvcPlugin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
import org.springframework.web.socket.WebSocketHandler;

import java.time.Clock;

@SpringBootApplication
@EnableWebSecurity
@EnableWebSocket
@EnableSwagger
@PropertySource("classpath:application.properties")
public class Application implements WebSocketConfigurer {
    private WebSocketHandler echoWebsocketHandler;

    @Autowired
    public Application(final WebSocketHandler echoWebsocketHandler) {
        this.echoWebsocketHandler = echoWebsocketHandler;
    }

    @Override
    public void registerWebSocketHandlers(final WebSocketHandlerRegistry registry) {
        registry.addHandler(this.echoWebsocketHandler, "/echo").setAllowedOrigins("*");
    }

    @Bean
    public Clock clock() {
        return Clock.systemUTC();
    }

    @Bean
    public WebSecurityConfigurerAdapter securityConfigurer() {
        return new WebSecurityConfigurerAdapter() {
            @Override
            protected void configure(final HttpSecurity http) throws Exception {
                http.authorizeRequests().anyRequest().permitAll();
            }
        };
    }

    @Bean
    @Autowired
    public SwaggerSpringMvcPlugin customImplementation(final SpringSwaggerConfig springSwaggerConfig) {
        return new SwaggerSpringMvcPlugin(springSwaggerConfig)
                .apiInfo(new ApiInfo(
                        "SpringBoot-web",
                        null,
                        null,
                        "github.com/ViBiOh",
                        "ISC",
                        null
                ))
                .useDefaultResponseMessages(false)
                .includePatterns(".*");
    }

    public static void main(final String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
