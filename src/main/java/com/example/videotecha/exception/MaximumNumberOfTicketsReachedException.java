package com.example.videotecha.exception;

public class MaximumNumberOfTicketsReachedException extends RuntimeException {
    public MaximumNumberOfTicketsReachedException(String errorMessage) {
        super(errorMessage);
    }
}
