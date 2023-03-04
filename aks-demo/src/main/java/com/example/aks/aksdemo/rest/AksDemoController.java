package com.example.aks.aksdemo.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class AksDemoController {

    @GetMapping
    public String demo() {
        return "Hello Murilo! :)";
    }
}
