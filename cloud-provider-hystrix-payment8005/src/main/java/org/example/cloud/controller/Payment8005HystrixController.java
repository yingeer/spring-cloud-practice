package org.example.cloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.cloud.service.PaymentHystrixService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
public class Payment8005HystrixController {

    @Resource
    private PaymentHystrixService paymentService;

//    @Resource
//    private FeignExerciseService feignExerciseService;

    @Value("${server.port}")
    private String serverPort;

    @GetMapping("/payment/hystrix/{id}")
    public String paymentInfo_OK(@PathVariable("id") Integer id) {
        String result = paymentService.paymentInfo_OK(id);
        log.info("****o(*￣▽￣*)ブ****");
        return result;
    }

    @GetMapping("/payment/hystrix/timeout/{id}")
    public String paymentInfo_Timeout(@PathVariable("id") Integer id) {
        String result = paymentService.paymentInfo_Timeout(id);
        log.info("****(ノへ￣、)****");
        return result;
    }

//    @GetMapping("/payment/openfeign/exercise/{id}")
//    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
//        return feignExerciseService.getPaymentById(id);
//    }
}
