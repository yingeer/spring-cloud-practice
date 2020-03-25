package org.example.alibabacloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class AlibabaConsumer9002Application {

    public static void main(String[] args) {
        SpringApplication.run(AlibabaConsumer9002Application.class);
    }
}
