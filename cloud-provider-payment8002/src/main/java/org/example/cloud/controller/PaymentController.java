package org.example.cloud.controller;

//import com.netflix.discovery.DiscoveryClient;
import org.mortbay.log.Log;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.example.cloud.entities.CommonResult;
import org.example.cloud.entities.Payment;
import org.example.cloud.service.IPaymentService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    @Resource
    private IPaymentService IPaymentService;

    @Value("${server.port}")
    private String serverPort;

    @Resource
    private DiscoveryClient discoveryClient;

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

    @GetMapping("/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {
        Payment payment = IPaymentService.getPaymentById(id);
        if (payment != null) {
            return new CommonResult<>(200, "查询成功 server port is: "+serverPort, payment);
        } else {
            return new CommonResult<>(444, "查询失败", null);
        }
    }

    @GetMapping("/discovery")
    public Object discover() {
        List<String> services = discoveryClient.getServices();
        for (String service: services) {
            Log.info("*****service*****:" + service);
        }
        List<ServiceInstance> serviceInstances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance serviceInstance: serviceInstances) {
            Log.info("地址" + serviceInstance.getHost()+":"+serviceInstance.getPort()+"\t"+serviceInstance.getUri());
        }
        return serviceInstances;
    }
}
