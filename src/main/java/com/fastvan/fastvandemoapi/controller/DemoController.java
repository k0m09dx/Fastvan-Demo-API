package com.fastvan.fastvandemoapi.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import redis.clients.jedis.Jedis;

import java.util.Map;

@RestController
public class DemoController {

    private static Jedis jedis = new Jedis("godash-dev-ntnzjs.serverless.usw1.cache.amazonaws.com", 6379);

    public DemoController(){
    }
    @GetMapping(path = "cache/{id}")
    public String getCacheData(@PathVariable("id") String id){
        try {
            return (String) jedis.get(id);
        }catch (Exception ex){
            throw new RuntimeException(ex);
        }
    }

    @PostMapping(path = "cache/{id}")
    public ResponseEntity<String> setCacheData(@PathVariable("id") String id, @RequestBody Map<String, String> data){
        try {
            ObjectMapper mapper = new ObjectMapper();
            String result = mapper.writeValueAsString(data);
            jedis.set(id, result);
            return new ResponseEntity<>("Data Uploaded successfully", HttpStatus.OK);
        }catch (Exception ex){
            throw new RuntimeException(ex);
        }
    }


    @GetMapping(path = "hello")
    public String hello() {
        return "Good Morning. Hello World i'm build in Azure Pipelines!";
    }
}
