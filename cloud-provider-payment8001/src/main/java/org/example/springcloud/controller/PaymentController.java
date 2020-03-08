package org.example.springcloud.controller;

import org.example.springcloud.entities.CommonResult;
import org.example.springcloud.entities.Payment;
import org.example.springcloud.service.IPaymentService;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Resource
    private IPaymentService IPaymentService;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping("/create")
    @ResponseBody
    public CommonResult<Payment> create(Payment payment) {

        int result = IPaymentService.create(payment);
        if (result > 0) {
            return new CommonResult<Payment>(200, "插入成功 server port is: " + serverPort, null);
        } else {
            return new CommonResult<>(444, "插入失败", null);
        }
    }

    @ResponseBody
    @GetMapping("/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        Payment payment = IPaymentService.getPaymentById(id);
        if (payment != null) {
            return new CommonResult<>(200, "查询成功 server port is: "+serverPort, payment);
        } else {
            return new CommonResult<>(444, "查询失败", null);
        }
    }
}
