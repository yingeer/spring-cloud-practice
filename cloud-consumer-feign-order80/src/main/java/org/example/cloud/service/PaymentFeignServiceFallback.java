package org.example.cloud.service;

import org.example.cloud.entities.CommonResult;
import org.example.cloud.entities.Payment;
import org.springframework.stereotype.Component;

@Component
public class PaymentFeignServiceFallback implements PaymentFeignService {
    @Override
    public CommonResult<Payment> getPaymentById(Long id) {
        return null;
    }
}
