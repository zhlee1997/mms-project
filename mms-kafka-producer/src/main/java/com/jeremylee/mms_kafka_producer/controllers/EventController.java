package com.jeremylee.mms_kafka_producer.controllers;

import com.jeremylee.mms_kafka_producer.services.KafkaMessagePublishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("kafka-producer")
public class EventController {

    @Autowired
    private KafkaMessagePublishService kafkaMessagePublishService;

    @PostMapping("/publish/{message}")
    public ResponseEntity<?> publishMessage(@PathVariable String message) {
        try {
            for (int i = 0; i < 10000; i++) {
                kafkaMessagePublishService.sendMessageToTopic(message + i);
            }
            return ResponseEntity.ok("Message published successfully");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}
