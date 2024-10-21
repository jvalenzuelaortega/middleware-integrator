package com.example.middleware.infrastructure.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.middleware.application.register.PingService;

import reactor.core.publisher.Mono;

@RestController
public class PingController {
	
	private PingService pingService;
	
	public PingController(PingService pingService) {
		this.pingService = pingService;
	}

	@GetMapping("/ping")
	public Mono<ResponseEntity<String>> getPong() {
		return Mono.just(ResponseEntity.ok(pingService.getPong()));
	}
}
