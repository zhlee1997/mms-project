package com.jeremylee.mms_config_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class MmsConfigServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MmsConfigServiceApplication.class, args);
	}

}
