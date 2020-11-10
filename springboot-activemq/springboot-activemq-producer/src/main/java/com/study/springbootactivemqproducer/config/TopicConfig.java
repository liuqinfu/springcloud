package com.study.springbootactivemqproducer.config;

import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.jms.Topic;

/**
 * @author： leon
 * @date： 2020/11/10 20:58
 * @description： TODO
 * @modifiedBy：
 * @version: 1.0
 */
@Configuration
public class TopicConfig {

    @Value("${topic}")
    private String topicName;

    //1 将队列注入到spring容器
    @Bean
    public Topic topic(){
        return new ActiveMQTopic(topicName);
    }
}
