package com.example.middleware.infrastructure.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.middleware.config.FeignConfig;
import com.example.middleware.infrastructure.api.dto.CompanyDto;

@FeignClient(value = "empresa", url = "http://localhost:5000", configuration = FeignConfig.class)
public interface AssistanceApiClient {

	@GetMapping("/get-assistance-by-company")
	CompanyDto getAssistanceByFactory();

}
