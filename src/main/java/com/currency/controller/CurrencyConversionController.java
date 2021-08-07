package com.currency.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.currency.entities.CurrencyConversion;
import com.currency.repo.CurrencyConversionRepository;

@RestController
public class CurrencyConversionController {
	
	@Autowired
	CurrencyConversionRepository currencyConversionRepository;
	
	@Autowired
	Environment environment;
	
	
	@GetMapping("/currency-exchange/{id}")
	public CurrencyConversion getCurrencyConversion(@PathVariable("id")Long id) {
		 CurrencyConversion currencyConversion = currencyConversionRepository.findById(id).get();
		 currencyConversion.setPort(Integer.valueOf(environment.getProperty("local.server.port")));
		 return currencyConversion;
	}
	
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public CurrencyConversion currencyConversion(@PathVariable("from")String conversionFrom, @PathVariable("to")String conversionTo) {
		return currencyConversionRepository.findByConversionFromAndConversionTo(conversionFrom, conversionTo);
	}

}
