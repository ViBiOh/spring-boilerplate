package org.vibioh.config;

import com.mangofactory.swagger.configuration.SpringSwaggerConfig;
import com.mangofactory.swagger.models.dto.ApiInfo;
import com.mangofactory.swagger.plugin.EnableSwagger;
import com.mangofactory.swagger.plugin.SwaggerSpringMvcPlugin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import java.time.Clock;

@Configuration
@EnableAutoConfiguration
@EnableWebSecurity
@EnableSwagger
@ComponentScan(value = "org.vibioh")
@PropertySource("classpath:application.properties")
public class Application {
    @Bean
    public Clock clock() {
        return Clock.systemUTC();
    }

    @Bean
    public WebSecurityConfigurerAdapter securityConfigurer() {
        return new WebSecurityConfigurerAdapter() {
            @Override protected void configure(final HttpSecurity http) throws Exception {
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

    public static void main(final String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }
}
