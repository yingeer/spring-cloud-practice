package org.example.cloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.example.cloud.service.TestService;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RefreshScope
public class FlowLimitController {

    private int number = 0;

    @GetMapping("/testA")
    public String testA() throws InterruptedException {
        number++;
        Thread.sleep(1000);
        System.out.println("(～￣▽￣)～");
        return "---------testA，目前：" + number;
    }

    @GetMapping("/testB")
    public String testB() {

        return "------testB";
    }


    @Resource
    private TestService service;

    @GetMapping(value = "/hello/{name}")
    public String apiHello(@PathVariable String name) {
        return service.sayHello(name);
    }

    @GetMapping("/bysource")
    @SentinelResource(value = "byResource", blockHandler = "fallBack", fallback = "fuck")
    public String bySource() throws InterruptedException {
//        Thread.sleep(3000);
        int a = 2/0;
        return "byresource成功";
    }

    public String fallBack(BlockException ex) {
        return "bysource失败";
    }

    public String fuck() {
        return "我要操林";
    }
}
