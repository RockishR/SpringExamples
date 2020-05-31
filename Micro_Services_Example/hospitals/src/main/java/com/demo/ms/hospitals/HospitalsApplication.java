package com.demo.ms.hospitals;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class HospitalsApplication {

	public static void main(String[] args) {
		SpringApplication.run(HospitalsApplication.class, args);
	}

}
