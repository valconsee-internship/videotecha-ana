package com.example.videotecha.exception;

import com.example.videotecha.dto.ErrorDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@RestControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({ObjectAlreadyExistsException.class,
                       BusinessLogicException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    protected ErrorDto handleBadRequestException(RuntimeException e) {
        return new ErrorDto(e.getMessage(), HttpStatus.BAD_REQUEST, LocalDateTime.now());
    }

    @ExceptionHandler(EntityNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    protected ErrorDto handleNotFoundException(RuntimeException e) {
        return new ErrorDto(e.getMessage(), HttpStatus.NOT_FOUND, LocalDateTime.now());
    }

}
