package com.example.demo;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

import javax.validation.constraints.NotEmpty;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.convert.DurationUnit;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

@Component
@ConfigurationProperties("earnest")
@Validated //JSR-303
public class TestProperties {

    // TIP: 프로퍼티 검증.
    @NotEmpty
    private String name;

    private int age;
    private String fullName;

    // TIP: 시간 정보를 받고 싶은 경우.
    // @DurationUnit(ChronoUnit.SECONDS) // resource property에서 25s의 형식으로 작성하면 어노테이션 필요없이 스프링이 알아서 처리해줌.
    private Duration sessionTimeout = Duration.ofSeconds(30);

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getFullName() {
        return this.fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Duration getSessionTimeout() {
        return sessionTimeout;
    }

    public void setSessionTimeout(Duration sessionTimeout) {
        this.sessionTimeout = sessionTimeout;
    }

}