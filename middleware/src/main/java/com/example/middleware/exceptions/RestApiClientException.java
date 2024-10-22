package com.example.middleware.exceptions;

import feign.Response.Body;

public class RestApiClientException extends Exception {

	private static final long serialVersionUID = 6741858131361377458L;
	
	public RestApiClientException(String requestUrl, Body responseBody) {
		// TODO Auto-generated constructor stub
	}


}
