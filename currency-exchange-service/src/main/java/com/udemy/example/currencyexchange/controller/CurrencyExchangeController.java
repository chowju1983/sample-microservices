package com.udemy.example.currencyexchange.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.udemy.example.currencyexchange.entity.ExchangeValue;
import com.udemy.example.currencyexchange.service.CurrencyExchangeService;

@RestController
public class CurrencyExchangeController {
	
	private Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private CurrencyExchangeService currencyExchangeService;
	
	@Autowired
	private Environment environment;
	
	@GetMapping("/conversionfactor/{from}/to/{to}")
	public ExchangeValue retrieveMultiplicityFactor(@PathVariable(name="from")String from,
			@PathVariable(name="to")String to) {
		LOGGER.debug("Inside CurrencyExchangeController");
		ExchangeValue exchangeVal = new ExchangeValue();
		exchangeVal =  currencyExchangeService.fetchConversionFactor(from, to);
		exchangeVal.setPort(Integer.parseInt(environment.getProperty("local.server.port")));		
		return exchangeVal;
	}

}
