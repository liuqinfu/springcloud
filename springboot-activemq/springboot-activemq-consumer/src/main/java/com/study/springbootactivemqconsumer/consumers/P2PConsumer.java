package com.study.springbootactivemqconsumer.consumers;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * @author： leon
 * @date： 2020/11/10 21:40
 * @description： TODO
 * @modifiedBy：
 * @version: 1.0
 */
@Component
public class P2PConsumer {

    @JmsListener(destination = "${queue}")
    public void receive(String message){
        System.out.println("P2P消费者收到消息:"+message);
    }
}
