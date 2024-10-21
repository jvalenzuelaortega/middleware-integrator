package com.example.middleware.application.assistance;

import org.springframework.stereotype.Service;

import com.example.middleware.application.register.RegisterService;
import com.example.middleware.infrastructure.api.dto.AssistanceDto;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import reactor.core.publisher.Mono;

@Service
public class AssistanceService {
	
	private RegisterService registerService;
	

	public AssistanceService(RegisterService registerService) {
		this.registerService = registerService;
	}

	@CircuitBreaker(name = "myService", fallbackMethod = "fallBackMethod")
	public Mono<AssistanceDto> getAssistanceByWorker() {
		
		
		return Mono.just(null);
	}
	
	public String fallbackMethod(Exception e) {
        return "Fallback response due to: " + e.getMessage();
    }
}
