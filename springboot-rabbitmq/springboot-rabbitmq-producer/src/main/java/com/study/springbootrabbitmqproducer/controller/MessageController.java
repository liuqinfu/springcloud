package com.study.springbootrabbitmqproducer.controller;

import com.study.springbootrabbitmqproducer.producers.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author： leon
 * @date： 2020/11/15 18:25
 * @description： TODO
 * @modifiedBy：
 * @version: 1.0
 */
@RestController
@RequestMapping("msg")
public class MessageController {

    @Autowired
    private Producer producer;

    @GetMapping("send")
    public String sendMessage(String queueName){
        producer.send(queueName);
        return "success";
    }
}
