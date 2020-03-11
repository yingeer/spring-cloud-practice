package org.example.cloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.example.cloud.entities.CommonResult;
import org.example.cloud.entities.Payment;
import org.example.cloud.service.PaymentFeignService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@Slf4j
@DefaultProperties(defaultFallback = "fallBack")
public class OrderFeignController {

    @Resource
    private PaymentFeignService paymentFeignService;

    @ResponseBody
//    @HystrixCommand(fallbackMethod = "fallBack", commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "1000")
//    })
    @HystrixCommand
    @GetMapping(value = "/consumer/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        return paymentFeignService.getPaymentById(id);
    }

    private CommonResult<Payment> fallBack() {
        return null;
    }
}
