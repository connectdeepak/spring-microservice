package com.example.order.config;

import org.springframework.http.HttpStatus;

import com.example.order.exception.MyCustomBadRequestException;
import com.example.order.exception.MyCustomServerException;

import feign.Response;
import feign.codec.ErrorDecoder;

public class MyCustomErrorDecoder implements ErrorDecoder{
	
	private final ErrorDecoder defaultErrorDecoder = new Default();

	@Override
	public Exception decode(String methodKey, Response response) {
		
		HttpStatus httpStatus = HttpStatus.valueOf(response.status());
		if(httpStatus.is5xxServerError()) {
			return new MyCustomBadRequestException("Remote server error");
		}
		
		else if(httpStatus.is4xxClientError()) {
			return new MyCustomServerException("Remote client error");
		}
		
		else {
			return defaultErrorDecoder.decode(methodKey, response);
			
			
		}
	}

}
