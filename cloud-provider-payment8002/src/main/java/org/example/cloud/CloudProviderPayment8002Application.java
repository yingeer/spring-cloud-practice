package org.example.cloud;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

import javax.servlet.ServletRegistration;

@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker
public class CloudProviderPayment8002Application {
    public static void main(String[] args) {

        SpringApplication.run(CloudProviderPayment8002Application.class);
    }


}
