package com.udemy.example.currencyconversion.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.udemy.example.currencyconversion.beans.CurrencyConversionBean;

@Component
@FeignClient(name="sample-zuul-server")
//@RibbonClient(name="sample-zuul-server")
public interface CurrencyConversionFeignProxy {
	
	@GetMapping("/currency-exchange-service/conversionfactor/{from}/to/{to}")
	public CurrencyConversionBean retrieveMultiplicityFactor(@PathVariable(name="from")String from,
			@PathVariable(name="to")String to);

}
