package com.example.middleware.infrastructure.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.middleware.application.assistance.AssistanceService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class MiddlewareController {
	
	private AssistanceService assistanceService;

	public MiddlewareController(AssistanceService assistanceService) {
		this.assistanceService = assistanceService;
	}

	@GetMapping("/obtener-asistencia-por-trabajador")
	public Mono<ResponseEntity<String>> getAssistanceByWorker() {
		
		return Mono.just(null);
	}

}
