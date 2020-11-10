package com.study.springbootactivemqproducer.producers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.jms.Topic;

/**
 * @author： leon
 * @date： 2020/11/10 21:01
 * @description： TODO
 * @modifiedBy：
 * @version: 1.0
 */
@Component
public class TopicProducer {

    //每隔5秒相对列发送消息
    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    @Autowired
    private Topic topic;

    @Scheduled(fixedDelay = 5000)
    public void send(){
        long timeMillis = System.currentTimeMillis();
        String x = "Topic发送消息:" + timeMillis;
        jmsMessagingTemplate.convertAndSend(topic, x);
        System.out.println(x);
    }

}
