package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class SampleRunner implements ApplicationRunner {

    @Autowired
    TestProperties testProperties;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println(">>>>>>>>>>>>>>>>>>>");
        System.out.println(testProperties.getName());
        System.out.println(testProperties.getFullName());
        System.out.println(testProperties.getAge());
        System.out.println(testProperties.getSessionTimeout());
    }
    
}