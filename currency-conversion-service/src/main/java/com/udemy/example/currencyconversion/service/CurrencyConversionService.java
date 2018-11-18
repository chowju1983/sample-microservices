package com.udemy.example.currencyconversion.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.udemy.example.currencyconversion.beans.CurrencyConversionBean;

@Service
public class CurrencyConversionService {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Autowired
	private CurrencyConversionFeignProxy feignProxy;
	
	
	public CurrencyConversionBean calculateExhangeValue(String from, String to, Double quantity) {
		Map<String, String> uriVariables = new HashMap<String, String>();
		uriVariables.put("from", from);
		uriVariables.put("to", to);
		
		ResponseEntity<CurrencyConversionBean> response = restTemplate.getForEntity("http://localhost:8000/conversionfactor/{from}/to/{to}", 
				CurrencyConversionBean.class, uriVariables);	
		
		CurrencyConversionBean finalResponse = response.getBody();
		finalResponse.setQuantity(quantity);
		finalResponse.setCalculatedAmount(quantity*Integer.parseInt(finalResponse.getConversionFactor()));
		
		return finalResponse;
	}
	
	
	public CurrencyConversionBean calculateExhangeValueUsingFeign(String from, String to, Double quantity) {
		
		CurrencyConversionBean finalResponse = feignProxy.retrieveMultiplicityFactor(from, to);	
		finalResponse.setQuantity(quantity);
		finalResponse.setCalculatedAmount(quantity*Integer.parseInt(finalResponse.getConversionFactor()));
		
		return finalResponse;
	}
	
	
}
