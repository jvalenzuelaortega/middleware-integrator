package com.example.middleware.infrastructure.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;

@Getter
public class AbsencesDto {

	@JsonProperty("por_licencia_medica")
	private Long byMedicalLicense;
	
	@JsonProperty("sin_justificacion")
	private Long withoutJustification;
	
	@JsonProperty("vacaciones")
	private Long vacation;
}
