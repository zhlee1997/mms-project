package com.jeremylee.mms_api_gateway.config;

import java.util.function.Function;

import org.springframework.cloud.gateway.route.Route;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.Buildable;
import org.springframework.cloud.gateway.route.builder.PredicateSpec;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator routeLocator(RouteLocatorBuilder builder) {

        Function<PredicateSpec, Buildable<Route>> routeTest = predicateSpec -> predicateSpec
                // can match on headers, host, request method, query parameter
                // matches on the path
                .path("/get")
                .filters(gatewayFilterSpec -> gatewayFilterSpec
                        // can be Autheication Header
                        .addRequestHeader("MyHeader", "MyURI")
                        .addRequestParameter("Param", "MyValue"))
                // can be URL of microservices
                .uri("http://httpbin.org:80");

        Function<PredicateSpec, Buildable<Route>> routeInventory = predicateSpec -> predicateSpec.path("/inventory/**")
                // inventory-service -> talk to Eureka, find the location of this service
                // lb -> and load balancing between instances which are returned
                .uri("lb://inventory-service");

        Function<PredicateSpec, Buildable<Route>> routeSupplier = predicateSpec -> predicateSpec.path("/suppliers/**")
                // inventory-service -> talk to Eureka, find the location of this service
                // lb -> and load balancing between instances which are returned
                .uri("lb://mms-supplier-service");

        return builder.routes()
                .route(routeTest)
                .route(routeInventory)
                .route(routeSupplier)
                .build();
    }

}
