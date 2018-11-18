package com.udemy.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.udemy.example.config.ConfigProperties;

@RestController
@RibbonClient(name="sample-microservice-example")
public class ConfigController{
	
	@Autowired
	private ConfigProperties configProperties;
	
	@Autowired
	private Environment environment;
	
	

	@GetMapping("/hello")
	public String getFromConfig() {
		String s =  configProperties.getMessage()+configProperties.getMessage2() + environment.getProperty("server.port");
		String fooResourceUrl = "http://localhost:9001/sample-spring-config-service/hello";
		RestTemplate template = new RestTemplate();
		ResponseEntity<String> s1 = template.getForEntity(fooResourceUrl, String.class);
		return s+s1;
		
	}
}
