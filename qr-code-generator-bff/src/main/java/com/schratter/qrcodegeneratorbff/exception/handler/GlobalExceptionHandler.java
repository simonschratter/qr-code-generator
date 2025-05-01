package com.schratter.qrcodegeneratorbff.exception.handler;

import com.schratter.qrcodegeneratorbff.exception.InvalidImageTypeException;
import com.schratter.qrcodegeneratorbff.model.error.CustomErrorResponse;
import com.schratter.qrcodegeneratorbff.model.error.ErrorDetail;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(InvalidImageTypeException.class)
    public ResponseEntity<CustomErrorResponse> handleInvalidImageType(InvalidImageTypeException ex) {
        CustomErrorResponse errorResponse = new CustomErrorResponse();
        errorResponse.setTimestamp(LocalDateTime.now());
        errorResponse.setStatus(HttpStatus.BAD_REQUEST.value());

        List<ErrorDetail> errorDetails = new ArrayList<>();
        errorDetails.add(new ErrorDetail("imageType", ex.getMessage()));

        errorResponse.setErrors(errorDetails);
        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<CustomErrorResponse> handleValidationErrors(MethodArgumentNotValidException ex) {
        CustomErrorResponse errorResponse = new CustomErrorResponse();
        errorResponse.setTimestamp(LocalDateTime.now());
        errorResponse.setStatus(HttpStatus.BAD_REQUEST.value());

        List<ErrorDetail> errorDetails = new ArrayList<>();
        ex.getBindingResult().getFieldErrors().forEach(error -> {
            String field = error.getField();
            String message = error.getDefaultMessage();
            errorDetails.add(new ErrorDetail(field, message));
        });

        errorResponse.setErrors(errorDetails);

        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
}