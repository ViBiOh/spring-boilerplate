package org.vibioh.controller;

import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import com.wordnik.swagger.annotations.ApiResponse;
import com.wordnik.swagger.annotations.ApiResponses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.vibioh.model.Hello;
import org.vibioh.service.DateService;

@RestController
@RequestMapping(value = "hello", produces = MediaType.APPLICATION_JSON_VALUE)
@Api(value = "Ressource that say Hello", produces = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin(origins = {"*"}, allowedHeaders = {"Content-Type"}, methods = {RequestMethod.GET, RequestMethod.POST})
public class HelloWorldController {
    @Value("${app.name}")
    private String appName;

    private DateService dateService;

    @Autowired
    public HelloWorldController(final DateService dateService) {
        this.dateService = dateService;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "Default Hello")
    @ApiResponses({
            @ApiResponse(code = 200, message = "A greeting message with timestamp", response = Hello.class)
    })
    public Hello get() {
        return new Hello(appName, dateService.now().toEpochMilli());
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "Create Hello")
    @ApiResponses({
            @ApiResponse(code = 200, message = "A greeting message with timestamp", response = Hello.class)
    })
    public Hello create() {
        return new Hello(appName, dateService.now().toEpochMilli());
    }

    @RequestMapping(value = "{name}", method = RequestMethod.GET)
    @ResponseBody
    @ApiOperation(value = "Hello with given name", response = Hello.class)
    @ApiResponses({
            @ApiResponse(code = 200, message = "A personalized message with timestamp", response = Hello.class)
    })
    public Hello getName(
            @ApiParam(value = "Name to greet", allowMultiple = false, required = true) final @PathVariable
                    String name) {
        return new Hello(name, dateService.now().toEpochMilli());
    }
}
