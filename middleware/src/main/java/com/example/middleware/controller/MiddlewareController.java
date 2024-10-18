package com.example.middleware.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.middleware.service.LiquidationService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Controller
public class MiddlewareController {
	
	private LiquidationService liquidationService;

	public MiddlewareController(LiquidationService liquidationService) {
		this.liquidationService = liquidationService;
	}

	@PostMapping("/calculate-liquidation")
	public Flux<ResponseEntity<String>> calculateLiquidation() {
		return Flux.just(null);
	}
	
	@PostMapping("/upload-payroll")
	public Mono<ResponseEntity<String>> uploadPayroll() {
		liquidationService.makeAction();
		
		return Mono.just(null);
	}
}

