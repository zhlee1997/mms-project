package com.jeremylee.mms_inventory_service.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

@Component
public class TokenUtils {
    @Value("${auth.token.jwtSecret}")
    private String jwtSecret;

    @PostConstruct
    public void printConfig() {
        System.out.println("JWT Secret from Config Server: " + jwtSecret);
    }
}
