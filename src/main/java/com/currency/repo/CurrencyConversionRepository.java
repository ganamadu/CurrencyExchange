package com.currency.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.currency.entities.CurrencyConversion;

public interface CurrencyConversionRepository extends JpaRepository<CurrencyConversion, Long> {

	CurrencyConversion findByConversionFromAndConversionTo(String conversionFrom, String conversionTo);


}
