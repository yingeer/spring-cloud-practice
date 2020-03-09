package org.example.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class CloudConsumerZKOrder80Application {
    public static void main(String[] args) {
        SpringApplication.run(CloudConsumerZKOrder80Application.class);
    }
}
