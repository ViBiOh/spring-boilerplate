package org.vibioh.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.vibioh.model.Hello;
import org.vibioh.service.DateService;

@RestController
@RequestMapping("/hello")
@Api(description = "Ressource that say Hello", tags = {"Hello"})
public class HelloWorldController {
    @Value("${app.name}")
    private String appName;

    private DateService dateService;

    @Autowired
    public HelloWorldController(final DateService dateService) {
        this.dateService = dateService;
    }

    @RequestMapping("")
    @ResponseBody
    @ApiOperation(
            value = "Hello with the default name",
            httpMethod = "GET")
    @ApiResponses({
            @ApiResponse(code = 200, message = "A greeting message with timestamp", response = Hello.class)
    })
    public Hello hello() {
        return new Hello(appName, dateService.now().toEpochMilli());
    }


    @RequestMapping("{name}")
    @ResponseBody
    @ApiOperation(
            value = "Hello with the given name",
            httpMethod = "GET")
    @ApiResponses({
            @ApiResponse(code = 200, message = "A personalized message with timestamp", response = Hello.class)
    })
    public Hello helloName(
            @ApiParam(value = "Name to greet", allowMultiple = false, required = true) final @PathVariable
                    String name) {
        return new Hello(name, dateService.now().toEpochMilli());
    }
}
