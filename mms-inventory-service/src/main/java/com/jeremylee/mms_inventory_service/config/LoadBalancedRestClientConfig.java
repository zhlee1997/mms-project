package com.jeremylee.mms_inventory_service.config;

import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
@EnableDiscoveryClient
public class LoadBalancedRestClientConfig {

    @Bean
    @LoadBalanced // Enables Eureka-aware service discovery (resolution of service names to URLs)
    public RestClient.Builder restClientBuilder() {
        return RestClient.builder();
    }

    @Bean
    public RestClient restClient(RestClient.Builder builder) {
        return builder.build();
    }
}