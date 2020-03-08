package org.example.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class CloudProviderPayment9999Application {
    public static void main(String[] args) {
        SpringApplication.run(CloudProviderPayment9999Application.class);
    }
}
