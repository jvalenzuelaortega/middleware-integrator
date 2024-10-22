package com.example.middleware.infrastructure.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;

@Getter
public class DetailDto {

	@JsonProperty("empleado_id")
	private Long employeeId;
	
    @JsonProperty("nombre_empleado")
	private String employeeName;
    
    @JsonProperty("fecha_de_inicio")
	private String startDate;
    
    @JsonProperty("fecha_de_termino")
	private String endDate;
    
    @JsonProperty("horas_totales_trabajadas")
	private Long totalHoursWorked;
    
    @JsonProperty("asistencia")
	private String attendance;

	@JsonProperty("tipo")
	private String type;
	
    @JsonProperty("horas_extras")
	private Long overtime;
}
