package com.example.videotecha.exception;

public class ProjectionStartTimeInPastException extends RuntimeException {
    public ProjectionStartTimeInPastException(String errorMessage) {
        super(errorMessage);
    }
}
