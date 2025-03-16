package com.jeremylee.mms_inventory_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy // Enables Aspect-Oriented Programming (AOP)
public class MmsInventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MmsInventoryServiceApplication.class, args);
	}

}
