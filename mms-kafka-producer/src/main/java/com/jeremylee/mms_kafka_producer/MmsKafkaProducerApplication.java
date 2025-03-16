package com.jeremylee.mms_kafka_producer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class MmsKafkaProducerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MmsKafkaProducerApplication.class, args);
	}

}
