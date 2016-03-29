package org.vibioh.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.vibioh.model.Hello;

@RestController
public class HelloWorldController {
   @Value("${app.name}")
   private String appName;

   @RequestMapping("/hello")
   @ResponseBody
   public Hello hello() {
	return new Hello(appName);
   }
}
