package org.example.cloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class NacosController {

    @Value("${config.info}")
    private String configInfo;

    @GetMapping(value = "/config/info")
    public String echo() {
        return this.configInfo;
    }
}
