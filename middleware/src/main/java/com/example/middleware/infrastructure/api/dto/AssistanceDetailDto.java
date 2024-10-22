package com.example.middleware.infrastructure.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter; 

@Getter
public class AssistanceDetailDto {

	@JsonProperty("total_horas")
	private Long totalHours;
	
	@JsonProperty("horas_extras")
	private Long overtimeHours;
	
	@JsonProperty("asistencias")
	private Long attendances;
	
	@JsonProperty("inasistencias")
	private AbsencesDto absencesDto;
}
