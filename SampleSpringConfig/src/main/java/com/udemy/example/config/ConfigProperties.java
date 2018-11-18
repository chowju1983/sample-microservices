package com.udemy.example.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix="sample.cloud")
public class ConfigProperties {

	private String message;
	private String message2;

	/**
	 * @return the message2
	 */
	public String getMessage2() {
		return message2;
	}

	/**
	 * @param message2 the message2 to set
	 */
	public void setMessage2(String message2) {
		this.message2 = message2;
	}

	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}

}
