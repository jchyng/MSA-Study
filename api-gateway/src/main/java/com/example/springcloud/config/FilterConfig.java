package com.example.springcloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//어노테이션만 빼줘도 인식되지 스프링에 않는다.
//@Configuration
public class FilterConfig{
//    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder){
        //application.yml에 있던 routes와 같은 내용
        return builder.routes()
                .route(r -> r.path("/first-service/**")
                        .filters(f -> f.addRequestHeader("first-request", "first-request-header")
                                .addRequestHeader("first-response", "first-response-header"))
                        .uri("http://localhost:8001"))
                .route(r -> r.path("/second-service/**")
                        .filters(f -> f.addRequestHeader("second-request", "second-request-header")
                                .addRequestHeader("second-response", "second-response-header"))
                        .uri("http://localhost:8002"))
                .build();
    }
}
