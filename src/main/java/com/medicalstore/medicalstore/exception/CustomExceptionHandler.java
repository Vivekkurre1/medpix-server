package com.medicalstore.medicalstore.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.medicalstore.medicalstore.response.CustomResponse;

@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public final ResponseEntity<CustomResponse<Void>> handleAllExceptions(RuntimeException ex, WebRequest request) {
        CustomResponse<Void> errorResponse = new CustomResponse<>(true, ex.getMessage(), null);
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

}
