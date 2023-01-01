package com.java.test.junior.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.LinkedHashMap;
import java.util.Map;

import static java.time.LocalDateTime.now;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@ControllerAdvice
public class ExceptionHandling {

    @ExceptionHandler(ProductNotExistsException.class)
    public ResponseEntity<Object> handleProductNotExistsException() {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", now());
        body.put("message", "Product not found");

        return new ResponseEntity<>(body, NOT_FOUND);
    }
}
