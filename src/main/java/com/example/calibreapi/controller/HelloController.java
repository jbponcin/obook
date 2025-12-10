package com.example.calibreapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileWriter;
import java.io.IOException;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello() {
        try (FileWriter writer = new FileWriter("hello.txt", false)) {
            writer.write("Hello from the controller!");
        } catch (IOException e) {
            return "Error writing to file.";
        }
        return "Hello, World!";
    }
}
