package com.example.videotecha.dto;

import org.springframework.http.HttpStatus;

import java.sql.Timestamp;

public class ErrorDto {

    private String message;
    private HttpStatus httpStatus;
    private Timestamp timestamp;

    public ErrorDto() {
    }

    public ErrorDto(String message, HttpStatus httpStatus, Timestamp timestamp) {
        this.message = message;
        this.httpStatus = httpStatus;
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    @Override
    public String toString() {
        return "ErrorDto{" +
                "message='" + message + '\'' +
                ", httpStatus=" + httpStatus +
                ", timestamp=" + timestamp +
                '}';
    }

}
