package com.study.springbootactivemqproducer.config;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.jms.Queue;

/**
 * @author： leon
 * @date： 2020/11/10 20:58
 * @description： TODO
 * @modifiedBy：
 * @version: 1.0
 */
@Configuration
public class QueueConfig {

    @Value("${queue}")
    private String queueName;

    //1 将队列注入到spring容器
    @Bean
    public Queue queue(){
        return new ActiveMQQueue(queueName);
    }
}
