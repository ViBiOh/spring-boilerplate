package org.vibioh.controller;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.vibioh.model.Hello;
import org.vibioh.service.DateService;

@RestController
@RequestMapping("/hello")
@Api("Ressource that say Hello")
public class HelloWorldController {
    @Value("${app.name}")
    private String appName;

    private DateService dateService;

    @Autowired
    public HelloWorldController(final DateService dateService) {
        this.dateService = dateService;
    }

    @RequestMapping(value = "", method = RequestMethod.GET, produces = RestExceptionHandler.JSON)
    @ResponseBody
    @ApiOperation(value = "Default Hello", response = Hello.class)
    @ApiResponses({
            @ApiResponse(code = 200, message = "A greeting message with timestamp")
    })
    public Hello hello() {
        return new Hello(appName, dateService.now().toEpochMilli());
    }


    @RequestMapping(value = "{name}", method = RequestMethod.GET, produces = RestExceptionHandler.JSON)
    @ResponseBody
    @ApiOperation(value = "Hello with given name", response = Hello.class)
    @ApiResponses({
            @ApiResponse(code = 200, message = "A personalized message with timestamp")
    })
    public Hello helloName(
            @ApiParam(value = "Name to greet", allowMultiple = false, required = true) final @PathVariable
                    String name) {
        return new Hello(name, dateService.now().toEpochMilli());
    }
}
