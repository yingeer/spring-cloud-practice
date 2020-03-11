package org.example.cloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.example.cloud.service.ConsumerFeignHystrixService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
public class ConsumerFeignHystrixController {

    @Resource
    private ConsumerFeignHystrixService service;

    @GetMapping("/consumer/payment/hystrix/{id}")
    public String paymentInfo_OK(@PathVariable("id") Integer id) {
        return service.paymentInfo_OK(id);
    }

    @GetMapping("/consumer/payment/hystrix/timeout/{id}")
    public String paymentInfo_Timeout(@PathVariable("id") Integer id) {
        return service.paymentInfo_Timeout(id);
    }

}
