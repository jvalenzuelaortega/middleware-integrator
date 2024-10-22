package com.example.middleware.application.register;

import java.time.LocalDateTime;
import java.util.HashMap;

import org.springframework.stereotype.Service;

import com.example.middleware.domain.entity.RegisterDocument;
import com.example.middleware.domain.repository.RegisterMongoRepository;
import reactor.core.publisher.Mono;

@Service
public class RegisterService {

	private final RegisterMongoRepository registerMongoRepository;
	
	public RegisterService(RegisterMongoRepository registerMongoRepository) {
		this.registerMongoRepository = registerMongoRepository;
	}
	
	public Mono<RegisterDocument> saveRegisterDocument(HashMap<String, String> parameters) {
		RegisterDocument registerEntity = RegisterDocument.builder()
				.userName(parameters.get("username"))
				.companyName(parameters.get("company"))
				.period(parameters.get("period"))
				.endpoint(parameters.get("endpoint"))
				.responseCode(parameters.get("response-code"))
				.responseDetail(parameters.get("response-detail"))
				.date(LocalDateTime.now().toString())
				.build();
		
		return registerMongoRepository.insert(registerEntity);
	}
	
}
