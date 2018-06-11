package com.example.backendapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/test")
    public String test(){
        return "test";
    }

    @GetMapping("/unsecured")
    public String unsecured(){
        return "unsecured";
    }
}
