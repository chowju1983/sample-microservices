package com.udemy.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class SampleSpringConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SampleSpringConfigServerApplication.class, args);
	}
}
