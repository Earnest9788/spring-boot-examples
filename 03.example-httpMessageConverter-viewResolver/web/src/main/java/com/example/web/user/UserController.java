package com.example.web.user;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    
    @GetMapping("/hello")
    public String hello() {
        return "Hello world";
    }

    // @PostMapping("/user") 
    // public @ResponseBody User create(@RequestBody User user) {
    //     // @RestController 어노테이션이 있는 경우 @ResponseBody는 생략해도된다.
    //     // (@Controller의 경우는 리턴 값에 해당하는 뷰를 찾으려고 하기 때문에 x!)
    //     return null;
    // }

    @PostMapping("/users/create")
    public User create(@RequestBody User user) {
        return user;
    }

}