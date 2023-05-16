package org.vibioh;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.MessageSource;
import org.vibioh.controller.Greeter;
import org.vibioh.model.Hello;

import java.util.Locale;

import static java.time.format.DateTimeFormatter.ISO_INSTANT;


@SpringBootApplication
public class Application implements CommandLineRunner {
  private static final Logger logger = LoggerFactory.getLogger(Application.class);
  private final Greeter greeter;
  private final MessageSource messageSource;
  @Value("${app.name}")
  private String appName;

  public Application(Greeter greeter, MessageSource messageSource) {
    this.greeter = greeter;
    this.messageSource = messageSource;
  }

  public static void main(final String[] args) {
    SpringApplication.run(Application.class, args);
  }

  @Override
  public void run(final String... strings) throws Exception {
    Hello hello = greeter.name("ViBiOh");

    logger.info(messageSource.getMessage("hello", new Object[]{appName, hello.name(), ISO_INSTANT.format(hello.moment())}, new Locale("fr", "FR")));
  }
}
