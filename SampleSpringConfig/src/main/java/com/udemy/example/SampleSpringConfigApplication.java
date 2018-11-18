package com.udemy.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SampleSpringConfigApplication {

	public static void main(String[] args) {
		SpringApplication.run(SampleSpringConfigApplication.class, args);
	}
}
