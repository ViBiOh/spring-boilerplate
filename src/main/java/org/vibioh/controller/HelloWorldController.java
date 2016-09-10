package org.vibioh.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.vibioh.model.Hello;

@RestController
@RequestMapping("/hello")
public class HelloWorldController {
    @Value("${app.name}")
    private String appName;

    @RequestMapping("")
    @ResponseBody
    public Hello hello() {
        return new Hello(appName);
    }


    @RequestMapping("{name}")
    @ResponseBody
    public Hello helloName(final @PathVariable String name) {
        return new Hello(name);
    }
}
