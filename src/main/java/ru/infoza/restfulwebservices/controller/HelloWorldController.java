package ru.infoza.restfulwebservices.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class HelloWorldController {

    private final MessageSource messageSource;

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

    @GetMapping( "/hello-i18n")
    public String sayHelloInternationalized() {
        var locale = LocaleContextHolder.getLocale();
        return messageSource.getMessage("good.morning.message",null, "Default Message", locale);
    }


}
