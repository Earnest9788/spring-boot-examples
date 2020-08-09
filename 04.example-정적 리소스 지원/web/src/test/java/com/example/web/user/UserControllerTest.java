package com.example.web.user;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.hamcrest.Matchers.*;
//import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@WebMvcTest(UserController.class)
public class UserControllerTest {
    
    @Autowired
    MockMvc mockMvc;

    @Test
    public void hello() throws Exception {
        mockMvc
            .perform(MockMvcRequestBuilders.get("/hello"))
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andExpect(MockMvcResultMatchers.content().string("Hello world"));
    }


    // CASE1 : accept type JSON;
    @Test
    public void createUser_JSON() throws Exception {
        String userJson = "{\"username\":\"kiwoon\", \"password\":\"123\"}";

        mockMvc
            .perform(
                MockMvcRequestBuilders
                    .post("/users/create")
                    .contentType(MediaType.APPLICATION_JSON_UTF8)
                    .accept(MediaType.APPLICATION_JSON_UTF8)
                    .content(userJson)
            )
            .andExpect(
                MockMvcResultMatchers
                    .status()
                    .isOk()
            )
            .andExpect(
                MockMvcResultMatchers
                    .jsonPath("$.username", is(equalTo("kiwoon")))
            )
            .andExpect(
                MockMvcResultMatchers
                    .jsonPath("$.password", is(equalTo("123")))
            );
    }

    // CASE2 : accept type XML;
    //       : XML message converter 디펜던시 추가 필요.
    @Test
    public void createUser_XML() throws Exception {
        String userJson = "{\"username\":\"kiwoon\", \"password\":\"123\"}";

        mockMvc
            .perform(
                MockMvcRequestBuilders
                    .post("/users/create")
                    .contentType(MediaType.APPLICATION_JSON_UTF8)
                    .accept(MediaType.APPLICATION_XML)
                    .content(userJson)
            )
            .andExpect(
                MockMvcResultMatchers
                    .status()
                    .isOk()
            )
            .andExpect(
                MockMvcResultMatchers
                    .xpath("/User/username")
                    .string("kiwoon")
            )
            .andExpect(
                MockMvcResultMatchers
                    .xpath("/User/password")
                    .string("123")
            );
    }
}