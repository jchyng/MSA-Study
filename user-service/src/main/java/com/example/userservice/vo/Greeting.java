package com.example.userservice.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class Greeting {
    @Value("${greeting.message}")   //application.yml에서 값을 가져올 땐 ${}사용
    private String message;

}
