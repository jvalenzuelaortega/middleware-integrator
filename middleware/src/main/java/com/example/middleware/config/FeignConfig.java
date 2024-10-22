package com.example.middleware.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.ObjectMapper;

import feign.codec.Decoder;
import feign.codec.Encoder;
import feign.codec.ErrorDecoder;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;

@Configuration
public class FeignConfig {

    @Bean
    Decoder decoder(ObjectMapper objectMapper) {
	    return new JacksonDecoder(objectMapper);
	}

    @Bean
    Encoder encoder(ObjectMapper objectMapper) {
	    return new JacksonEncoder(objectMapper);
	}
    
    @Bean
    ErrorDecoder errorDecoder() {
        return new CustomErrorDecodeConfig();
    }
}
