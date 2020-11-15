package com.study.rabbitmqservice.producer;

import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.study.rabbitmqservice.producer.config.ConnectionUtil;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author： leon
 * @date： 2020/11/14 10:19
 * @description： TODO
 * @modifiedBy：
 * @version: 1.0
 */
public class SimpleRabbitmqProducer {

    public static void main(String[] args) throws IOException, TimeoutException {
        Connection connection = ConnectionUtil.getConnection();
        Channel channel = connection.createChannel();
        AMQP.Queue.DeclareOk adminqueue = channel.queueDeclare("adminqueue", false, false, false, null);
        channel.basicQos(1);
        String msg="first rabbitmq message";
        channel.basicPublish("","adminqueue",null,msg.getBytes());
        System.out.println("生产者发送消息："+msg);
        channel.close();
        connection.close();
    }
}
