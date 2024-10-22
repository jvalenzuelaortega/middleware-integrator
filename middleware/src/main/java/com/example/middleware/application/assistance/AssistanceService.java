package com.example.middleware.application.assistance;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.middleware.application.register.RegisterService;
import com.example.middleware.infrastructure.api.AssistanceApiClient;
import com.example.middleware.infrastructure.api.dto.CompanyDto;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Timer;
import reactor.core.publisher.Mono;

@Service
public class AssistanceService {

	private final RegisterService registerService;
	private final AssistanceApiClient assistanceApiClient;
	private final MeterRegistry meterRegistry;

	public AssistanceService(RegisterService registerService, AssistanceApiClient assistanceApiClient,
			MeterRegistry meterRegistry) {
		this.registerService = registerService;
		this.assistanceApiClient = assistanceApiClient;
		this.meterRegistry = meterRegistry;
	}

	public Mono<CompanyDto> getAssistanceByWorker(Map<String,String> allParams) {
		// Start Metrics
		Counter customCounter = meterRegistry.counter("get_assistance_service_counter", "Service", "Assistance");
		Timer customTimer = meterRegistry.timer("get_assistance_service_timer");
		customCounter.increment();
		Timer.Sample sample = Timer.start(meterRegistry);
		
		CompanyDto company = assistanceApiClient.getAssistanceByFactory();

		// End metrics
		sample.stop(customTimer);
		
		return validateAndSaveRegister(company, allParams).flatMap(isValidate -> {
			if(isValidate) {
				return Mono.just(company);
			}else {
				return Mono.empty();
			}
		});
	}

	private Mono<Boolean> validateAndSaveRegister(CompanyDto company, Map<String,String> allParams) {
		HashMap<String, String> generateParams = new HashMap<>();
		if (company == null) {
			generateParams.put("username", "test-user");
			generateParams.put("company", allParams.get("company"));
			generateParams.put("period", allParams.get("period"));
			generateParams.put("endpoint", "obtener-asistencia-por-trabajador");
			generateParams.put("response-code", "500");
			generateParams.put("response-detail", "Error");	
		} else {
			generateParams.put("username", "test-user");
			generateParams.put("company", allParams.get("rut_empresa"));
			generateParams.put("period", allParams.get("periodo"));
			generateParams.put("endpoint", "obtener-asistencia-por-trabajador");
			generateParams.put("response-code", "200");
			generateParams.put("response-detail", "Succesfull");
		}
		
		return registerService.saveRegisterDocument(generateParams).flatMap(entity -> {
			boolean isEmpty = entity != null;
            return Mono.just(isEmpty);
        });
	}
	
}
