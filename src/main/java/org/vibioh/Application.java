package org.vibioh;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.vibioh.controller.Greeter;
import org.vibioh.controller.Reader;
import org.vibioh.controller.Writer;
import org.vibioh.model.Hello;

import java.util.Arrays;
import java.util.Locale;


@SpringBootApplication
public class Application implements CommandLineRunner {
  private static final Logger logger = LoggerFactory.getLogger(Application.class);

  private final Locale locale = Locale.of("fr", "FR");

  private final Reader reader;
  private final Greeter greeter;
  private final Writer writer;

  public static void main(final String[] args) {
    SpringApplication.run(Application.class, args);
  }

  public Application(Reader reader, Greeter greeter, Writer writer) {
    this.reader = reader;
    this.greeter = greeter;
    this.writer = writer;
  }

  @Override
  public void run(final String... strings) throws Exception {
    logger.info("Application started with args={}", Arrays.toString(strings));

    writer.write("Name: ", locale);
    Hello hello = greeter.name(this.reader.read());

    writer.write(greeter.render(hello, locale), locale);
  }
}
