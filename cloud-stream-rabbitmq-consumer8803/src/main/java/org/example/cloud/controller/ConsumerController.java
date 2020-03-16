package org.example.cloud.controller;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

@Component
@EnableBinding(Sink.class)
public class ConsumerController {

    @StreamListener(Sink.INPUT)
    public void getMess(Message<String> message) {
        System.out.println(message.getPayload());
    }
}
