package com.example.aljis.Spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Value;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("api/value")
public class ValueExample {

    @Value("${greeting:default value}")
    private String message;
    @Value("some static message")
    private String staticMessage;

    @Autowired
    private DbSettings dbSettings;
    @GetMapping
    public List<String> printValues() {

        return Arrays.asList(message, staticMessage, dbSettings.toString());
    }
}
