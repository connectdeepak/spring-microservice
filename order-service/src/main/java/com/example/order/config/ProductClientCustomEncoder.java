package com.example.order.config;

import java.lang.reflect.Type;

import com.fasterxml.jackson.databind.ObjectMapper;

import feign.RequestTemplate;
import feign.codec.EncodeException;
import feign.codec.Encoder;

public class ProductClientCustomEncoder implements Encoder {

	@Override
	public void encode(Object object, Type bodyType, RequestTemplate template) throws EncodeException {
		
		String jsonString;
		try {
			jsonString = new ObjectMapper().writeValueAsString(object);
			template.header("Content-Type", "application/json");
			template.body(jsonString);
			
		} catch (Exception e) {
			throw new EncodeException("Unable to encode object to JSON", e);
		}
		
	}

}
