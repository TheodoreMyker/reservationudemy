package com.builtlab.reservatutionudemy.models;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.nio.file.AccessDeniedException;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ReservationAPIException.class)
    public ResponseEntity<ErrorDetails> handlerReservationApiException(ReservationAPIException exception, WebRequest request) {
        final ErrorDetails errorDetails = new ErrorDetails();
        errorDetails.setErrorCode(exception.getStatus().value());
        errorDetails.setErrorMessage(exception.getMessage());
        errorDetails.setDevErrorMessage(request.getDescription(false));
        errorDetails.setTimestamp(System.currentTimeMillis());
        return new ResponseEntity<>(errorDetails, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(AccessDeniedException.class)
    public ResponseEntity<ErrorDetails> handlerAccessDeniedException(AccessDeniedException exception, WebRequest request) {
        final ErrorDetails errorDetails = new ErrorDetails();
        errorDetails.setErrorMessage(exception.getMessage());
        errorDetails.setDevErrorMessage(request.getDescription(false));
        errorDetails.setTimestamp(System.currentTimeMillis());
        return new ResponseEntity<>(errorDetails, HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDetails> handlerGlobalException(Exception exception, WebRequest request) {
        final ErrorDetails errorDetails = new ErrorDetails();
        errorDetails.setErrorMessage(exception.getMessage());
        errorDetails.setDevErrorMessage(request.getDescription(false));
        errorDetails.setTimestamp(System.currentTimeMillis());
        return new ResponseEntity<>(errorDetails, HttpStatus.UNAUTHORIZED);
    }

}
