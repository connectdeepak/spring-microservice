package com.example.order.config;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import feign.FeignException;
import feign.Response;
import feign.codec.DecodeException;
import feign.codec.Decoder;

public class ProductClientCustomDecoder implements Decoder {

	@SuppressWarnings("unchecked")
	@Override
	public Object decode(Response response, Type type) throws IOException, DecodeException, FeignException {
	
	InputStream responseBody= response.body().asInputStream();
	
	return new ObjectMapper().readValue(responseBody, new TypeReference() {
		
		@Override
		public Type getType() {
			return type;
		}
	});
	
	
	}

}
