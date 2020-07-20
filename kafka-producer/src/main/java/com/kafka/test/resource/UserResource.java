package com.kafka.test.resource;

import com.kafka.test.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/kafka")
public class UserResource {

    @Autowired
    private KafkaTemplate<String, User> kafkaTemplate;

    private static final String TOPIC = "test-kafka";

    @PostMapping("/publish")
    public ResponseEntity post(@RequestBody User user) {

    kafkaTemplate.send(TOPIC, user);

    return ResponseEntity.accepted().build();

    }

}