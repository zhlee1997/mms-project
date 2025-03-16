package com.jeremylee.mms_kafka_consumer.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaMessageListenService {

    Logger logger = LoggerFactory.getLogger(KafkaMessageListenService.class);

//    need to specify what type of data this consumer will consume (String)
    @KafkaListener(topics = "mms-kafka-topic-2", groupId = "mms-consumer-group-2")
    public void consume1(String message) {
        logger.info("consumer1 consumed the message: {}", message);
    }

    @KafkaListener(topics = "mms-kafka-topic-2", groupId = "mms-consumer-group-2")
    public void consume2(String message) {
        logger.info("consumer2 consumed the message: {}", message);
    }

    @KafkaListener(topics = "mms-kafka-topic-2", groupId = "mms-consumer-group-2")
    public void consume3(String message) {
        logger.info("consumer3 consumed the message: {}", message);
    }

    @KafkaListener(topics = "mms-kafka-topic-2", groupId = "mms-consumer-group-2")
    public void consume4(String message) {
        logger.info("consumer4 consumed the message: {}", message);
    }

    @KafkaListener(topics = "mms-kafka-topic-2", groupId = "mms-consumer-group-2")
    public void consume5(String message) {
        logger.info("consumer5 consumed the message: {}", message);
    }
}
