package org.example.cloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class ConfigController {

    @Value("${aiai.name}")
    private String aiaiObject;

    @GetMapping("/aiai/get")
    public String getAiaiObject() {
        return this.aiaiObject;
    }
}

