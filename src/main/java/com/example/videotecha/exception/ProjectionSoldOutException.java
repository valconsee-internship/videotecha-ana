package com.example.videotecha.exception;

public class ProjectionSoldOutException extends RuntimeException {
    public ProjectionSoldOutException(String errorMessage) {
        super(errorMessage);
    }
}
