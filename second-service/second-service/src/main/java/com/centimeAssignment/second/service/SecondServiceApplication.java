package com.centimeAssignment.second.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@SpringBootApplication
@ComponentScan({"com.centimeAssignment.second.service"})
public class SecondServiceApplication {
public static void main(String[] args) {
		SpringApplication.run(SecondServiceApplication.class, args);
	}

}
