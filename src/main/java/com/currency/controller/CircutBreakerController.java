package com.currency.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;

@RestController
public class CircutBreakerController {
	Logger LOGGER  = LoggerFactory.getLogger(CircutBreakerController.class);
	
	
	@GetMapping("/sample-api")
	//@Retry(name = "sample-api", fallbackMethod = "hardcodedResponse")
	@CircuitBreaker(name = "default", fallbackMethod = "hardcodedResponse")
	@RateLimiter(name = "default")
	//10s ==> 10000 calls to the sample api
	public String sampleApi() {
		LOGGER.info("Called Sampe API method....");
		String sampleApiResp = new RestTemplate().getForEntity("http://localhost:8080/some-dummy-url", String.class).getBody();
		
		return sampleApiResp;
	}
		
	public String hardcodedResponse(Exception ex) {
		return "fallback-response";
	}

}
