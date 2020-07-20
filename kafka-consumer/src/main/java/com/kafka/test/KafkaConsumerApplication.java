package com.kafka.test;

import com.kafka.test.model.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;

@SpringBootApplication
public class KafkaConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(KafkaConsumerApplication.class, args);
	}

	@KafkaListener(topics = "test-kafka", groupId = "foo")
	public void listen(User user) {
		System.out.println("Received Message is: " + user);
	}

}
