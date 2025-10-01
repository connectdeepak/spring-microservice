package com.example.order;

public class MyCustomServerException extends RuntimeException {
    
    public MyCustomServerException(String message) {
        super(message);
    }
    
    public MyCustomServerException(String message, Throwable cause) {
        super(message, cause);
    }
}