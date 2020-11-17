package com.study.springbootrabbitmqproducer.producers;

import com.alibaba.fastjson.JSONObject;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
        JSONObject jsonObject = new JSONObject();
//        jsonObject.put("timestamp",1);
        jsonObject.put("timestamp",0);
        Message message = MessageBuilder.withBody(jsonObject.toJSONString().getBytes())
                .setContentType(MessageProperties.CONTENT_TYPE_JSON)
                .setContentEncoding("utf-8")
                .setMessageId(UUID.randomUUID()+"")
                .build();
        amqpTemplate.convertAndSend(queueName,message);
    }
}
