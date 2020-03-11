package org.example.cloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class PaymentHystrixService {

    public String paymentInfo_OK(Integer id) {
        return "线程池：" +Thread.currentThread().getName() + " paymentInfo_OK, id:\t" + id + "\t"+"o(*￣︶￣*)o";
    }

    @HystrixCommand(fallbackMethod = "fallBack", commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "3000")
    })
    public String paymentInfo_Timeout(Integer id) {

        int timeOut = 5;
//        int o = 10/0;
        try {
            TimeUnit.SECONDS.sleep(timeOut);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池：" + Thread.currentThread().getName() + " paymentInfo_OK, id:\t" + id + "\t" + "ヾ(≧へ≦)〃";
    }

    private String fallBack(Integer id) {
        return "( *^-^)ρ(*╯^╰)";
    }

}
