package com.currency.entities;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CurrencyConversion {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String conversionFrom;
	private String conversionTo;
	private BigDecimal conversionMultiple;
	private Integer port;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getConversionFrom() {
		return conversionFrom;
	}
	public void setConversionFrom(String conversionFrom) {
		this.conversionFrom = conversionFrom;
	}
	public String getConversionTo() {
		return conversionTo;
	}
	public void setConversionTo(String conversionTo) {
		this.conversionTo = conversionTo;
	}
	public BigDecimal getConversionMultiple() {
		return conversionMultiple;
	}
	public void setConversionMultiple(BigDecimal conversionMultiple) {
		this.conversionMultiple = conversionMultiple;
	}
	public Integer getPort() {
		return port;
	}
	public void setPort(Integer port) {
		this.port = port;
	}
}
