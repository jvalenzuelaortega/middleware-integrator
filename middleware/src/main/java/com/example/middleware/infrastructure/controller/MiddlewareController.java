package com.example.middleware.infrastructure.controller;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.middleware.application.assistance.AssistanceService;
import com.example.middleware.infrastructure.api.dto.CompanyDto;

import io.micrometer.core.instrument.MeterRegistry;
import reactor.core.publisher.Mono;

@RestController
public class MiddlewareController {
	
	private final AssistanceService assistanceService;
	private final MeterRegistry meterRegistry;

	public MiddlewareController(AssistanceService assistanceService, MeterRegistry meterRegistry) {
		this.assistanceService = assistanceService;
		this.meterRegistry = meterRegistry;
	}

	@GetMapping("/obtener-asistencia-por-trabajador")
	public Mono<ResponseEntity<?>> getAssistanceByWorker(@RequestParam Map<String,String> allParams) {

		Mono<CompanyDto> response = assistanceService.getAssistanceByWorker(allParams);
			
		return Mono.just(ResponseEntity.ok(response));
	}

}
