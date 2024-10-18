package com.example.middleware.service;

import org.springframework.stereotype.Service;

import io.micrometer.core.instrument.MeterRegistry;

@Service
public class LiquidationService {

	private final MeterRegistry meterRegistry;

	public LiquidationService(MeterRegistry meterRegistry) {
		this.meterRegistry = meterRegistry;
	}
	
	public void makeAction() {
        meterRegistry.counter("acciones.realizadas").increment();
        // logic
    }
}
