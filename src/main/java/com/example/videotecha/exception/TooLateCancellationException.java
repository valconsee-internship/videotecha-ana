package com.example.videotecha.exception;

public class TooLateCancellationException extends RuntimeException {
    public TooLateCancellationException(String errorMessage) {
        super(errorMessage);
    }
}
