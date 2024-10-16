package com.example.remunerationintegrator.service;

import org.springframework.cloud.client.circuitbreaker.CircuitBreaker;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AlbumService {

	private CircuitBreakerFactory circuitBreakerFactory;
	private RestTemplate restTemplate;

	public AlbumService(CircuitBreakerFactory circuitBreakerFactory) {
		this.circuitBreakerFactory = circuitBreakerFactory;
	}
	
	
	public String getAlbumList() {
	    CircuitBreaker circuitBreaker = circuitBreakerFactory.create("circuitbreaker");
	    String url = "https://jsonplaceholder.typicode.com/albums";

	    return circuitBreaker.run(() -> restTemplate.getForObject(url, String.class));
	}
	
}
