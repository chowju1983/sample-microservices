package com.udemy.example.currencyconversion;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.udemy.example.currencyconversion.beans.CurrencyConversionBean;
import com.udemy.example.currencyconversion.service.CurrencyConversionService;

@RestController
public class CurrencyConversionController {
	
	private Logger LOGGER = LoggerFactory.getLogger(this.getClass());

	
	@Autowired
	private CurrencyConversionService currencyConversionService;
	
	@GetMapping("/currency-conversion-service/from/{from}/to/{to}/{quantity}")
	public CurrencyConversionBean calculateExchangeVal(@PathVariable("from")String from,
			@PathVariable("to")String to, @PathVariable("quantity")Double quantity) {
		LOGGER.debug("Inside CurrencyConversionController");
		return currencyConversionService.calculateExhangeValue(from, to, quantity);
		
	}
	
	
	
	@GetMapping("/currency-conversion-service-feign/from/{from}/to/{to}/{quantity}")
	public CurrencyConversionBean calculateExchangeValUsingFeign(@PathVariable("from")String from,
			@PathVariable("to")String to, @PathVariable("quantity")Double quantity) {
		
		return currencyConversionService.calculateExhangeValueUsingFeign(from, to, quantity);
		
	}

}
