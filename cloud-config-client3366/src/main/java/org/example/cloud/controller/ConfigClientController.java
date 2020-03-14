package org.example.cloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfigClientController {

    @Value("${username.password}")
    protected String config;

    @GetMapping("/config/get")
    public String getConfig() {
        return config;
    }
}
