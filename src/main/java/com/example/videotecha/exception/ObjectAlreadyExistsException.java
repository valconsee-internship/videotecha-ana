package com.example.videotecha.exception;

public class ObjectAlreadyExistsException extends RuntimeException {
    public ObjectAlreadyExistsException(String errorMessage) {
        super(errorMessage);
    }
}
