package org.example.cloud.service;

import org.springframework.stereotype.Component;

@Component
public class ConsumerFeignHystrixServiceFallback implements ConsumerFeignHystrixService {
    @Override
    public String paymentInfo_OK(Integer id) {
        return "fucker";
    }

    @Override
    public String paymentInfo_Timeout(Integer id) {
        return "fucker me";
    }
}
