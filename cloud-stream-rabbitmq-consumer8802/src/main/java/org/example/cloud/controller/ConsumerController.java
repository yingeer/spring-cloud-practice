package org.example.cloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;


@Component
@RestController
@EnableBinding(Sink.class)
public class ConsumerController {

    @Value("${server.port}")
    public String port;

    @StreamListener(Sink.INPUT)
    public void input(Message<String> message) {
        System.out.println("消费者1号端口：" + port + " 收到的消息是: " + message.getPayload());
    }
}
