package com.centimeAssignment.third.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@SpringBootApplication
@ComponentScan({"com.centimeAssignment.third.service"})
public class ThirdServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ThirdServiceApplication.class, args);
	}

}
