package org.example.springcloud.service;

import org.apache.ibatis.annotations.Param;
import org.example.springcloud.entities.Payment;

public interface IPaymentService {
    public int create(Payment payment);

    public Payment getPaymentById(@Param("id") Long id);

}

