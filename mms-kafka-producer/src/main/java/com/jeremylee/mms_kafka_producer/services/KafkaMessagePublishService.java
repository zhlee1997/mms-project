package com.jeremylee.mms_kafka_producer.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class KafkaMessagePublishService {

    @Autowired
    private KafkaTemplate<String, Object> template;

    public void sendMessageToTopic(String message) {
        CompletableFuture<SendResult<String, Object>> future = template.send("mms-kafka-topic-2", message);
        future.whenComplete((result, exception) -> {
            if (exception == null) {
                System.out.println("Sent message=[" + message + "] with offset=[" + result.getRecordMetadata().offset() + "]");
                System.out.println("Sent message=[" + message + "] with partition=[" + result.getRecordMetadata().partition() + "]");
            } else {
                System.out.println("Unable to send message=[" + message + "] due to : [" + exception.getMessage() + "]");
            }
        });
    }
}
