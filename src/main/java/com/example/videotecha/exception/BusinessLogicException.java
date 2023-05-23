package com.example.videotecha.exception;

public class BusinessLogicException extends RuntimeException {
    public BusinessLogicException(String errorMessage) {
        super(errorMessage);
    }
}
