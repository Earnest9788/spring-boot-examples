package com.example.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringInitApplication {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(SpringInitApplication.class);
        app.run(args);
    }

}