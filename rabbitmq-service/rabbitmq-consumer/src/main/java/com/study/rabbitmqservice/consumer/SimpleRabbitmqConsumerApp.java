package com.study.rabbitmqservice.consumer;

import com.rabbitmq.client.*;
import com.study.rabbitmqservice.consumer.config.ConnectionUtil;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author： leon
 * @date： 2020/11/14 10:37
 * @description： TODO
 * @modifiedBy：
 * @version: 1.0
 */
public class SimpleRabbitmqConsumerApp {

    public static void main(String[] args) throws IOException, TimeoutException {
        Connection connection = ConnectionUtil.getConnection();
        Channel channel = connection.createChannel();
        channel.queueDeclare("adminqueue",false,false,false,null);
        channel.basicQos(1);
        DefaultConsumer consumer = new DefaultConsumer(channel){
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                String msg = new String(body,"utf-8");
                System.out.println("消费者消费消息："+msg);
                channel.basicAck(envelope.getDeliveryTag(), false);

            }
        };
        //设置签收模式 默认是自动签收   true:自动应答签收模式
        channel.basicConsume("adminqueue",false,consumer);


    }
}
