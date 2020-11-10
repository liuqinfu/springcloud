package com.study.springbootactivemqproducer.producers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.jms.Queue;

/**
 * @author： leon
 * @date： 2020/11/10 21:01
 * @description： TODO
 * @modifiedBy：
 * @version: 1.0
 */
@Component
public class P2PProducer {

    //每隔5秒相对列发送消息
    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    @Autowired
    private Queue queue;

    @Scheduled(fixedDelay = 5000)
    public void send(){

        long timeMillis = System.currentTimeMillis();
        String x = "P2P发送消息:" + timeMillis;
        System.out.println(x);
        jmsMessagingTemplate.convertAndSend(queue, x);
    }

}
