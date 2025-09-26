package ru.infoza.restful_web_services.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class HelloWorldController {

    @GetMapping( "/hello")
    public String sayHello() {
        return "Hello World!";
    }

    @GetMapping( "/hello-bean")
    public HelloWorldBean sayHelloBean() {
        return new HelloWorldBean("Hello World!");
    }

    @GetMapping( "/hello-bean/path-variable/{name}")
    public HelloWorldBean sayHelloBeanPathVariable(@PathVariable String name) {
        return new HelloWorldBean(String.format("Hello World, %s!", name));
    }

}
