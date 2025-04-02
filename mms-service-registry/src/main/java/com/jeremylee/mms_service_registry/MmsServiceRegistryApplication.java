package com.jeremylee.mms_service_registry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class MmsServiceRegistryApplication {

	public static void main(String[] args) {
		SpringApplication.run(MmsServiceRegistryApplication.class, args);
	}

}
