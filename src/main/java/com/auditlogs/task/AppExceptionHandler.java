package com.auditlogs.task;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class AppExceptionHandler {
    @ExceptionHandler(value = NoSuchElementFoundException.class)
    public ResponseEntity<ErrorResponse> handleNoSuchElementFoundException(NoSuchElementFoundException ex,WebRequest request){

        ErrorResponse response = new ErrorResponse();
        response.setMessage(ex.getMessage());
        response.setStatus(HttpStatus.NOT_FOUND.value());

        return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
    }
}
