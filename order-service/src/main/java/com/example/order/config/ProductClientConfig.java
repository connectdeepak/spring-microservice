package com.example.order.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.codec.Decoder;
import feign.codec.Encoder;
import feign.codec.ErrorDecoder;

@Configuration
public class ProductClientConfig {
    
	/*
	 * @Bean public Encoder myCustomEncoder() { return new
	 * ProductClientCustomEncoder(); }
	 * 
	 * @Bean public Decoder myCustomDecoder() { return new
	 * ProductClientCustomDecoder(); }
	 */
	
	@Bean
	public ErrorDecoder myCustomErrorDecoder() {
		return new MyCustomErrorDecoder();
	}
 
 
 
}
