package com.study.springbootrabbitmqconsumer.consumers;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author： leon
 * @date： 2020/11/15 22:25
 * @description： TODO
 * @modifiedBy：
 * @version: 1.0
 */
@Component
@RabbitListener(queues = {"email-queue"})
public class EmailConsumer {

    @RabbitHandler
    public void process(String msg){
        System.out.println("邮件消费者消费消息："+msg);
    }
}
