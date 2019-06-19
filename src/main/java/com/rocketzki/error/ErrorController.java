package com.rocketzki.error;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Map;
import java.util.NoSuchElementException;

@RestControllerAdvice
public class ErrorController {

    @GetMapping("/error")
    public Map handleError() {
        return Map.of("error", "An error occurred.");
    }

    @ExceptionHandler(NoSuchElementException.class)
    public Map handleNoElementException(NoSuchElementException ex) {
        return Map.of("error", ex.toString());

    }
}
