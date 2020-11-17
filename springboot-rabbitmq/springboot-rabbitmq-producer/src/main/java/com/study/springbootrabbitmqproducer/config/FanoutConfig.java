package com.study.springbootrabbitmqproducer.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * @author： leon
 * @date： 2020/11/15 12:39
 * @description： TODO
 * @modifiedBy：
 * @version: 1.0
 */
@Configuration
public class FanoutConfig {


    private String email_queue = "email-queue";
    private String sms_queue = "sms-queue";
    private String login_exchange = "login-exchange";

    private String dead_queue = "dead-queue";
    private String dead_exchange = "dead-exchange";
    private String dead_routing = "deadEmail";

    private String dead_letter_queue_key = "x-dead-letter-exchange";
    private String dead_letter_queue_routing_key = "x-dead-letter-routing-key";

    //1 定义队列
    @Bean
    public Queue emailQueue(){
        Map<String,Object> args = new HashMap<>();
        args.put(dead_letter_queue_key,dead_exchange);
        args.put(dead_letter_queue_routing_key,dead_routing);
        Queue queue = new Queue(email_queue,true,false,false,args);
        return queue;
    }
    @Bean
    public Queue smsQueue(){
        return new Queue(sms_queue);
    }
    //2 定义交换机
    @Bean
    public FanoutExchange loginExchange(){
        return new FanoutExchange(login_exchange);
    }
    //3 绑定交换机&队列
    @Bean
    public Binding bindingExchangeEmail(Queue emailQueue,FanoutExchange loginExchange){//参数利用了反射   参数名需要与实例化队列和交换机的方法名相同
        return BindingBuilder.bind(emailQueue).to(loginExchange);
    }
    @Bean
    public Binding bindingExchangeSms(Queue smsQueue,FanoutExchange loginExchange){//参数利用了反射   参数名需要与实例化队列和交换机的方法名相同
        return BindingBuilder.bind(smsQueue).to(loginExchange);
    }

    //定义死信队列
    @Bean Queue deadQueueEmail(){
        return new Queue(dead_queue, true);
    }

    //定义死信交换机
    @Bean
    public DirectExchange deadExchangeEmail(){
        return new DirectExchange(dead_exchange);
    }

    //创建死信交换机
    @Bean
    public Binding bindDeadExchangeEmail(Queue deadQueueEmail,DirectExchange deadExchangeEmail){
        return BindingBuilder.bind(deadQueueEmail).to(deadExchangeEmail).with(dead_routing);
    }

}
