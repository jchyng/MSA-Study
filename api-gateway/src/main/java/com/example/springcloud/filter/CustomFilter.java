package com.example.springcloud.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;


@Component
@Slf4j
public class CustomFilter extends AbstractGatewayFilterFactory<CustomFilter.Config> {
    public CustomFilter(){
        super(Config.class);
    }

    @Override
    public GatewayFilter apply(Config config){
        //Custom Pre Filter. suppose we can extract JWT(java web token) and perform authentication
        //필터링 후 서버로부터 토큰을 받고 가지고 있는 것 = 인증 확인
        return (exchange, chain) -> {
            ServerHttpRequest request = exchange.getRequest();
            ServerHttpResponse response = exchange.getResponse();

            log.info("Custom PRE filter: request id -> {}", request.getId());

            //custom post filter
            return chain.filter(exchange).then(Mono.fromRunnable(()->{
                log.info("Custom POST filter: response id -> {}", response.getStatusCode());
            }));
        };
    }

    public static class Config{
        //put the configuration properties
    }
}
