package com.example.videotecha.exception;

import com.example.videotecha.dto.ErrorDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.sql.Timestamp;

@RestControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({MaximumNumberOfTicketsReachedException.class,
                       MovieHasActiveProjectionException.class,
                       ObjectAlreadyExistsException.class,
                       ProjectionSoldOutException.class,
                       ProjectionsOverlappingException.class,
                       ProjectionStartTimeInPastException.class,
                       TooLateCancellationException.class})
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    protected ErrorDto handleBadRequestException(RuntimeException e) {
        return new ErrorDto(e.getMessage(), HttpStatus.BAD_REQUEST, new Timestamp(System.currentTimeMillis()));
    }

    @ExceptionHandler(EntityNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    protected ErrorDto handleNotFoundException(EntityNotFoundException e) {
        return new ErrorDto(e.getMessage(), HttpStatus.NOT_FOUND, new Timestamp(System.currentTimeMillis()));
    }
}
