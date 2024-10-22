package com.example.middleware.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;

import com.example.middleware.exceptions.RestApiClientException;
import com.example.middleware.exceptions.RestApiServerException;

import feign.Response;
import feign.codec.ErrorDecoder;

@Configuration
public class CustomErrorDecodeConfig implements ErrorDecoder{

		@Override
		public Exception decode(String methodKey, Response response) {
			String requestUrl = response.request().url();
	        Response.Body responseBody = response.body();
	        HttpStatus responseStatus = HttpStatus.valueOf(response.status());

	        if (responseStatus.is5xxServerError()) {
	            return new RestApiServerException(requestUrl, responseBody);
	        } else if (responseStatus.is4xxClientError()) {
	            return new RestApiClientException(requestUrl, responseBody);
	        } else {
	            return new Exception("Generic exception");
	        }
		}

}
