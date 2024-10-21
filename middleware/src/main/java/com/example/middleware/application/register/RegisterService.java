package com.example.middleware.application.register;

import org.springframework.stereotype.Service;

import com.example.middleware.domain.repository.RegisterRepository;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Timer;

@Service
public class RegisterService {

	private RegisterRepository registerRepository;
	private MeterRegistry meterRegistry;

	public RegisterService(RegisterRepository registerRepository, MeterRegistry meterRegistry) {
		this.registerRepository = registerRepository;
		this.meterRegistry = meterRegistry;
	}


}
