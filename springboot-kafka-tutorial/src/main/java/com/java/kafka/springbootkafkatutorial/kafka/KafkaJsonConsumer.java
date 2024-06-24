package com.java.kafka.springbootkafkatutorial.kafka;

import com.java.kafka.springbootkafkatutorial.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaJsonConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaJsonConsumer.class);
    @KafkaListener(topics = "json-topic",groupId = "myGroup")
    public void consume(User user){
        LOGGER.info(String.format("Message Recieved--->%s",user.toString()));
    }
}
