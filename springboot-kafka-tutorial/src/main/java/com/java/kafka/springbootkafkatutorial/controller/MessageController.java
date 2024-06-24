package com.java.kafka.springbootkafkatutorial.controller;

import com.java.kafka.springbootkafkatutorial.kafka.KafkaProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kafka/swetha/v1")
public class MessageController {
    private KafkaProducer kafkaProducer;

    public MessageController(KafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }
    // http://localhost:8080/kafka/swetha/v1/publish?message=HelloWorld from SpringBoot
    @GetMapping("/publish")
    public ResponseEntity<String> publish(String message){
        kafkaProducer.sendMessage(message);
        return ResponseEntity.ok("Message sent to the topic.");
    }

}
