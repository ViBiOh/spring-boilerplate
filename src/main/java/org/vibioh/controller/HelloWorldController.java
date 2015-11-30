package org.vibioh.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloWorldController {
  @Value("${app.name}")
  private String appName;

  @RequestMapping("/")
  @ResponseBody
  public String helloWorld() {
    return "Hello World!, I'm " + appName;
  }
}
