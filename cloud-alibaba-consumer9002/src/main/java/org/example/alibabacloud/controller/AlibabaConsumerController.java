package org.example.alibabacloud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class AlibabaConsumerController {

    @Resource
    private RestTemplate restTemplate;

    @GetMapping(value = "/invoke/{string}")
    public String echo(@PathVariable("string") String string) {
        return restTemplate.getForObject("http://alibaba-nacos/echo/" + string, String.class);
    }
}
