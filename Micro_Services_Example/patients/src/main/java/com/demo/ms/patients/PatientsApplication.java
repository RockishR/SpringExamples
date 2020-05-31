package com.demo.ms.patients;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class PatientsApplication {

	public static void main(String[] args) {
		SpringApplication.run(PatientsApplication.class, args);
	}

}
