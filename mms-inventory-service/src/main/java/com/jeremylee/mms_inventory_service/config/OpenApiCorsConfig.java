package com.jeremylee.mms_inventory_service.config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class OpenApiCorsConfig {

    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();

        config.setAllowCredentials(true);
        // config.setAllowedOrigins(List.of("http://localhost:8765")); // API Gateway
        // URL
        config.setAllowedOrigins(List.of("http://api-gateway:8765")); // API Gateway URL
        config.setAllowedHeaders(List.of("*"));
        config.setAllowedMethods(List.of("GET", "POST", "PUT", "DELETE", "OPTIONS"));

        // Apply CORS to Swagger endpoints
        // source.registerCorsConfiguration("/v3/api-docs/**", config);
        // source.registerCorsConfiguration("/swagger-ui/**", config);

        source.registerCorsConfiguration("/**", config);

        return new CorsFilter(source);
    }

}
