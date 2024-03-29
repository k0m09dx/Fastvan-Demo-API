package com.fastvan.fastvandemoapi.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.fastvan.fastvandemoapi.service.CacheService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequiredArgsConstructor
public class DemoController {

    private final CacheService cacheService;

    @GetMapping(path = "cache/{id}")
    public String getCacheData(@PathVariable("id") String id){
        try {
            return (String) cacheService.get(id);
        }catch (Exception ex){
            throw new RuntimeException(ex);
        }
    }

    @PostMapping(path = "cache/{id}")
    public ResponseEntity<String> setCacheData(@PathVariable("id") String id, @RequestBody Map<String, String> data){
        try {
            ObjectMapper mapper = new ObjectMapper();
            String result = mapper.writeValueAsString(data);
            cacheService.put(id, result);
            return new ResponseEntity<>("Data Uploaded successfully", HttpStatus.OK);
        }catch (Exception ex){
            throw new RuntimeException(ex);
        }
    }


    @GetMapping(path = "test")
    public String hello() {
        return "Good Morning. Hello World i'm build in Azure Pipelines!";
    }


}
