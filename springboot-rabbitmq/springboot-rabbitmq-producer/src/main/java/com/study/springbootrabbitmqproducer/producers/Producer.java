package com.study.springbootrabbitmqproducer.producers;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UUID;

/**
 * @author： leon
 * @date： 2020/11/15 18:21
 * @description： TODO
 * @modifiedBy：
 * @version: 1.0
 */
@Component
public class Producer {

    @Autowired
    private AmqpTemplate amqpTemplate;

    public void send(String queueName){
        System.out.println("queue_name:"+queueName);
        String msg = "message--"+new Date();
        Message message = MessageBuilder.withBody(msg.getBytes())
                .setContentType(MessageProperties.CONTENT_TYPE_JSON)
                .setContentEncoding("utf-8")
                .setMessageId(UUID.randomUUID()+"")
                .build();
        amqpTemplate.convertAndSend(queueName,message);
    }
}
