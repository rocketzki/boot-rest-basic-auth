package com.rocketzki;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.rocketzki.config", "com.rocketzki.controller", "com.rocketzki.domain"})
public class BasicRestApp {
    public static void main(String[] args) {
        SpringApplication.run(BasicRestApp.class, args);
    }


}
