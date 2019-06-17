package com.rocketzki.error;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class ErrorController {

    @GetMapping("/error")
    public Map error() {
        return Map.of("error", "An error occurred.");
    }
}
