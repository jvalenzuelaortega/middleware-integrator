package com.example.middleware.application.register;

import org.springframework.stereotype.Service;

import com.example.middleware.domain.repository.RegisterRepository;

@Service
public class RegisterService {
	
	private RegisterRepository registerRepository;

	public RegisterService(RegisterRepository registerRepository) {
		this.registerRepository = registerRepository;
	}
	
	

}
