package com.khuedev.demo.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class RestControlerDemo {
    @GetMapping("/hello")
    public String helloWorld(){
        return "Hello World!!!";
    }
}
