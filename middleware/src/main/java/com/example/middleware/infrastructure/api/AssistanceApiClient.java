package com.example.middleware.infrastructure.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.middleware.infrastructure.api.dto.CompanyDto;

@FeignClient(value = "empresa", url = "http://localhost:5000")
public interface AssistanceApiClient {

	@RequestMapping(method = RequestMethod.GET, value = "/get-assistance-by-company")
	CompanyDto getAssistanceByFactory();

}
