package com.java.kafka.springbootkafkatutorial.controller;

import com.java.kafka.springbootkafkatutorial.kafka.KafkaJsonProducer;
import com.java.kafka.springbootkafkatutorial.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kafka/swetha/v2")
public class JsonMessageController {
    private KafkaJsonProducer kafkaJsonProducer;

    public JsonMessageController(KafkaJsonProducer kafkaJsonProducer) {
        this.kafkaJsonProducer = kafkaJsonProducer;
    }
    @GetMapping("/publish")
    public ResponseEntity<String> publishJson(@RequestBody User user){
        kafkaJsonProducer.sendMessage(user);
        return ResponseEntity.ok("Json Message sent to Topic");
    }
}
