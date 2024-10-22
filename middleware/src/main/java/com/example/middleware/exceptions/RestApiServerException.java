package com.example.middleware.exceptions;

import feign.Response.Body;

public class RestApiServerException extends Exception {

	private static final long serialVersionUID = 4771929349977951819L;

	public RestApiServerException(String requestUrl, Body responseBody) {
		// TODO Auto-generated constructor stub
	}

}
