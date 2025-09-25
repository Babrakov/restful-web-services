package ru.infoza.restful_web_services.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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

}
