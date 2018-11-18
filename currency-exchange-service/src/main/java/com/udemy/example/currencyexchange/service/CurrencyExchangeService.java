package com.udemy.example.currencyexchange.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.udemy.example.currencyexchange.CurrencyExchangeRepo;
import com.udemy.example.currencyexchange.entity.ExchangeValue;

@Service
public class CurrencyExchangeService {
	
	@Autowired
	private CurrencyExchangeRepo currencyExchangeRepo;
	
	public ExchangeValue fetchConversionFactor(String from, String to) {
		return currencyExchangeRepo.findByFromAndTo(from, to);
	}

}
