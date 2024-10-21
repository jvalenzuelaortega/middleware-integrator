package com.example.middleware.domain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "register")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegisterEntity {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long registerId;
	private String userName;
	private String companyName;
	private String period;
	private String endpoint;
	private String responseCode;
	private String responseDetail;

}
