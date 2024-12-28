package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"Controller", "com.example.demo"})
public class EmiCalculatorApplication {
    public static void main(String[] args) {
        SpringApplication.run(EmiCalculatorApplication.class, args);
    }
}

