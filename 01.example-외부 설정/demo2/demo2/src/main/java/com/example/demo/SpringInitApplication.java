package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableConfigurationProperties(TestProperties.class)
public class SpringInitApplication {
    
    // TIP: Thirst party Configuration 프로퍼티를 가져오고 싶은 경우.
    @ConfigurationProperties("server")
    @Bean 
    public ServerProperties serverProperties() {
        return new ServerProperties();
    }

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(SpringInitApplication.class);
        app.run(args);
    }

}