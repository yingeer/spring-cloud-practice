package org.example.cloud.service.Impl;

import org.example.cloud.dao.PaymentDao;
import org.example.cloud.entities.Payment;
import org.example.cloud.service.IPaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PaymentService implements IPaymentService {

    @Resource
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
