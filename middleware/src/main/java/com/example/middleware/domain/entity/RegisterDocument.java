package com.example.middleware.domain.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Document(collection = "register")
@Getter
@Setter
@Builder
public class RegisterDocument {
	
	@Id
	private String id;

	private String userName;
	private String companyName;
	private String period;
	private String endpoint;
	private String responseCode;
	private String responseDetail;
	private String date;

}
