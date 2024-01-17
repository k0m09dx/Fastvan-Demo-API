package com.fastvan.fastvandemoapi.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @GetMapping(path = "hello")
    public String hello() {
        return " Good Morning. Hello World i'm build in Azure Pipelines!";
    }
}
