package com.BasilEcom.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/profile")
public class ProfileController {
    @Value("${app.environment}")
    private String environment;
    @GetMapping
    public String getProfile()
    {
        return "Current Environment :"+environment;
    }
}
