package com.example.middleware.infrastructure.api.dto;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
public class CompanyDto {

	@JsonProperty("id")
	private Long id;
	
	@JsonProperty("nombre")
	private String name;
	
	@JsonProperty("asistencia")
	private AssistanceDetailDto assistanceDto;
	
	@JsonProperty("detalles")
	private List<DetailDto> detailsDto = new ArrayList<>();
}
