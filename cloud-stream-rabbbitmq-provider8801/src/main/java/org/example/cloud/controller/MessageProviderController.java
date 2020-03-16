package org.example.cloud.controller;

import org.example.cloud.service.IMessProvider;
import org.springframework.boot.autoconfigure.batch.BatchDataSource;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class MessageProviderController {

//    @Resource
//    protected IMessProvider messageProviderImpl;
    @Resource
    private IMessProvider messageProviderImpl;

    @GetMapping("/sendMessage")
    public String sendMessage() {
        return messageProviderImpl.send();
    }

}
