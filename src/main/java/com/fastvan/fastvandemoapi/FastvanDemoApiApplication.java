package com.fastvan.fastvandemoapi;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.Serial;

@OpenAPIDefinition(servers= { @Server(url = "/common", description = "Default Server Pages")})
@SpringBootApplication(scanBasePackages = "com.fastvan.fastvandemoapi")
public class FastvanDemoApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(FastvanDemoApiApplication.class, args);
    }

}
