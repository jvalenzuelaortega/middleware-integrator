package com.example.middleware.application.register;

import java.util.HashMap;

import org.springframework.stereotype.Service;

import com.example.middleware.domain.entity.RegisterEntity;
import com.example.middleware.domain.repository.RegisterRepository;

@Service
public class RegisterService {

	private RegisterRepository registerRepository;
	public RegisterService(RegisterRepository registerRepository) {
		this.registerRepository = registerRepository;
	}
	
	public boolean keepRecordOfRequests(HashMap<String, String> parameters) {
		RegisterEntity registerEntity = RegisterEntity.builder()
				.userName(parameters.get("username"))
				.companyName(parameters.get("company"))
				.period(parameters.get("period"))
				.endpoint(parameters.get("endpoint"))
				.responseCode(parameters.get("response-code"))
				.responseDetail(parameters.get("responseDetail"))
				.build();
		
		RegisterEntity saveEntity = registerRepository.save(registerEntity);
		if (saveEntity.getRegisterId() > 0) {
			return true;
		}
		
		return false;
	}
	
}
