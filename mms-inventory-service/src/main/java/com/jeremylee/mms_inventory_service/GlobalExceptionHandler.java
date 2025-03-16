package com.jeremylee.mms_inventory_service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.jeremylee.mms_inventory_service.exception.ProductAlreadyExistsException;
import com.jeremylee.mms_inventory_service.exception.ProductNotFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {
    // ProductNotFoundException is a custom exception
    @ExceptionHandler({ ProductNotFoundException.class })
    public ResponseEntity<Object> handleProductNotFoundException(ProductNotFoundException exception) {
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(exception.getMessage());
    }

    // ProductAlreadyExistsException is a custom exception
    @ExceptionHandler({ ProductAlreadyExistsException.class })
    public ResponseEntity<Object> handleProductAlreadyExistsException(ProductAlreadyExistsException exception) {
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(exception.getMessage());
    }

    // RuntimeException is the parent class of all exceptions
    @ExceptionHandler({ RuntimeException.class })
    public ResponseEntity<Object> handleRuntimeException(RuntimeException exception) {
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(exception.getMessage());
    }
}
