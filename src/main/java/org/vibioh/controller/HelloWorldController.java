package org.vibioh.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.context.MessageSource;
import org.vibioh.model.Hello;
import org.vibioh.service.DateService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Locale;

@RestController
@RequestMapping(value = "hello", produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin(origins = {"*"}, allowedHeaders = {"Content-Type"}, methods = {RequestMethod.GET})
public class HelloWorldController {
    private static final Logger logger = LoggerFactory.getLogger(RestExceptionHandler.class);

    @Value("${app.name}")
    private String appName;

    @Autowired
    private DateService dateService;

    @Autowired
    private MessageSource messageSource;

    @GetMapping
    @ResponseBody
    public Hello get() {
        return new Hello(appName, dateService.now().toEpochMilli());
    }

    @GetMapping("{name}")
    @ResponseBody
    public Hello name(final @PathVariable String name) {
        logger.info(messageSource.getMessage("hello", new String[]{name}, new Locale("fr", "FR")));

        return new Hello(name, dateService.now().toEpochMilli());
    }
}
