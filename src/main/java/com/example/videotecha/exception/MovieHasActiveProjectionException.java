package com.example.videotecha.exception;

public class MovieHasActiveProjectionException extends RuntimeException {
    public MovieHasActiveProjectionException(String errorMessage) {
        super(errorMessage);
    }
}
