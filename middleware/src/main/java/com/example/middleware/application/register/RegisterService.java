package com.example.middleware.application.register;

import java.time.LocalDateTime;
import java.util.HashMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.example.middleware.application.assistance.AssistanceService;
import com.example.middleware.domain.entity.RegisterDocument;
import com.example.middleware.domain.repository.RegisterMongoRepository;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Timer;
import reactor.core.publisher.Mono;

@Service
public class RegisterService {

	Logger logger = LoggerFactory.getLogger(RegisterService.class);

	private final RegisterMongoRepository registerMongoRepository;
	private final MeterRegistry meterRegistry;

	public RegisterService(RegisterMongoRepository registerMongoRepository, MeterRegistry meterRegistry) {
		this.registerMongoRepository = registerMongoRepository;
		this.meterRegistry = meterRegistry;
	}

	public Mono<RegisterDocument> saveRegisterDocument(HashMap<String, String> parameters) {
		// Start Metrics
		Counter customCounter = meterRegistry.counter("insert_document_register_counter");
		Timer customTimer = meterRegistry.timer("insert_document_register_timer");
		customCounter.increment();
		Timer.Sample sample = Timer.start(meterRegistry);

		RegisterDocument registerEntity = RegisterDocument.builder().userName(parameters.get("username"))
				.companyName(parameters.get("company")).period(parameters.get("period"))
				.endpoint(parameters.get("endpoint")).responseCode(parameters.get("response-code"))
				.responseDetail(parameters.get("response-detail")).date(LocalDateTime.now().toString()).build();

		// End metrics
		sample.stop(customTimer);
		return registerMongoRepository.insert(registerEntity);
	}

}
