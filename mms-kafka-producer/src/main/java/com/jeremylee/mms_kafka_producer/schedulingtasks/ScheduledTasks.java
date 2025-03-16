package com.jeremylee.mms_kafka_producer.schedulingtasks;

import com.jeremylee.mms_kafka_producer.services.KafkaMessagePublishService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTasks {

    private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);

    @Autowired
    private KafkaMessagePublishService kafkaMessagePublishService;

    @Scheduled(cron = "0 * * * * *") // Cron expression for running every minute
    public void execute() {
        log.info("Scheduled Task called");
        kafkaMessagePublishService.sendMessageToTopic("helloworld");
    }
}
