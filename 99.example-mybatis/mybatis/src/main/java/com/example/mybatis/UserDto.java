package com.example.mybatis;

import org.springframework.stereotype.Component;

@Component
public class UserDto {
    
    private String id;
    private String name;

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

}