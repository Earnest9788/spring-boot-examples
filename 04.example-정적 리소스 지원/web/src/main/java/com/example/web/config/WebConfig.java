package com.example.web.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

// 스프링 부트가 제공해주는 web mvc 설정 외에 추가로 설정할 것이 있는 경우.
// 스프링 부트 기본 설정만으로 왠만한 것들은 다 가능하니 참조로 알아둘것.
@Configuration
public class WebConfig implements WebMvcConfigurer {
    
    // 정적 리소스 맵핑 핸들러. (프로퍼티로 맵핑하는것보다 여기서 추가하는 것을 추천함.)
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry
            .addResourceHandler("/m/**")
            .addResourceLocations("classpath:/m/") // 반드시 '/'로 끝나야 함.
            .setCachePeriod(20);
    }

}