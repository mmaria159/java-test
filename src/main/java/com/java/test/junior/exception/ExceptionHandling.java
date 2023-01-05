package com.java.test.junior.exception;

import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.LinkedHashMap;
import java.util.Map;

import static java.time.LocalDateTime.now;
import static java.util.stream.Collectors.toList;
import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@ControllerAdvice
public class ExceptionHandling {

    @ExceptionHandler(ProductNotExistsException.class)
    public ResponseEntity<Object> handleProductNotExistsException(ProductNotExistsException productNotExistsException) {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", now());
        body.put("message", productNotExistsException.getMessage());

        return new ResponseEntity<>(body, NOT_FOUND);
    }

    @ExceptionHandler(UserNotExistsException.class)
    public ResponseEntity<Object> handleProductNotExistsException(UserNotExistsException userNotExistsException) {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", now());
        body.put("message", userNotExistsException.getMessage());

        return new ResponseEntity<>(body, NOT_FOUND);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<Object> handleIllegalArgumentException(IllegalArgumentException illegalArgumentException) {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", now());
        body.put("message", illegalArgumentException.getMessage());

        return new ResponseEntity<>(body, NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleMethodArgumentNotValidException(MethodArgumentNotValidException methodArgumentNotValidException) {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", now());
        body.put("message", methodArgumentNotValidException
                .getBindingResult()
                .getAllErrors()
                .stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .collect(toList()));
        return new ResponseEntity<>(body, BAD_REQUEST);
    }
}
