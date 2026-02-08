package com.practice.real_estate_management_system.exception_handler;
import com.practice.real_estate_management_system.entity_dto.ErrorMessage;
import com.practice.real_estate_management_system.exceptions.PropertyNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(PropertyNotFoundException.class)
    public ResponseEntity<ErrorMessage> handleRuntimeException(PropertyNotFoundException ex, WebRequest request) {
        ErrorMessage message = new ErrorMessage(
                LocalDateTime.now(),
                HttpStatus.NOT_FOUND.value(),
                "Resource not found",
                ex.getMessage(),
                request.getDescription(false)
        );
        return new ResponseEntity<>(message, HttpStatus.NOT_FOUND);
    }
}