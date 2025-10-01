package com.example.order;

public class MyCustomBadRequestException extends RuntimeException {
    
    public MyCustomBadRequestException(String message) {
        super(message);
    }
    
    public MyCustomBadRequestException(String message, Throwable cause) {
        super(message, cause);
    }
}