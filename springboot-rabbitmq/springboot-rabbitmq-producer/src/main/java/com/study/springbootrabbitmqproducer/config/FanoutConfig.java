package com.study.springbootrabbitmqproducer.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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
    private String exchange_name = "login-exchange";

    //1 定义队列
    @Bean
    public Queue emailQueue(){
        return new Queue(email_queue);
    }
    @Bean
    public Queue smsQueue(){
        return new Queue(sms_queue);
    }
    //2 定义交换机
    @Bean
    public FanoutExchange loginExchange(){
        return new FanoutExchange(exchange_name);
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

}
