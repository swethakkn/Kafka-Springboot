package com.java.kafka.springbootkafkatutorial.kafka;

import com.java.kafka.springbootkafkatutorial.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class KafkaJsonProducer {
    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaJsonProducer.class);
    private KafkaTemplate<String, User> kafkaTemplate;

    public KafkaJsonProducer(KafkaTemplate<String, User> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }
    public void sendMessage(User data){
        LOGGER.info(String.format("Message Sent ---> %s",data.toString()));
        Message<User> message = MessageBuilder
                .withPayload(data)
                .setHeader(KafkaHeaders.TOPIC,"json-topic")
                .build();
        kafkaTemplate.send(message);
    }
}
