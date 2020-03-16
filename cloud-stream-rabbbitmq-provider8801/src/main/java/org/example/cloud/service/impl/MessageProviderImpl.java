package org.example.cloud.service.impl;

import org.example.cloud.service.IMessProvider;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.UUID;

@EnableBinding(Source.class)
@Service
public class MessageProviderImpl implements IMessProvider {

    @Resource
    private Source source;

    @Override
    public String send() {
        String uuid = UUID.randomUUID().toString();
        source.output().send(MessageBuilder.withPayload(uuid).build());
        System.out.println("流水线：" + uuid);
        return null;
    }
}
