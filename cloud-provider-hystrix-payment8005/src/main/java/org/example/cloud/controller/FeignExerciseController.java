package org.example.cloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.cloud.entities.CommonResult;
import org.example.cloud.entities.Payment;
import org.example.cloud.service.FeignExerciseService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@Slf4j
public class FeignExerciseController {

    @Resource
    private FeignExerciseService feignExerciseService;

    @ResponseBody
    @GetMapping("/payment/feign/exercise/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        return feignExerciseService.getPaymentById(id);
    }
}
