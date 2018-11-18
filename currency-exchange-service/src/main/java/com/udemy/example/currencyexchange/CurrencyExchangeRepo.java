/**
 * 
 */
package com.udemy.example.currencyexchange;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.udemy.example.currencyexchange.entity.ExchangeValue;


@Repository
public interface CurrencyExchangeRepo extends JpaRepository<ExchangeValue, Long> {
	ExchangeValue findByFromAndTo(String from, String to);
}
