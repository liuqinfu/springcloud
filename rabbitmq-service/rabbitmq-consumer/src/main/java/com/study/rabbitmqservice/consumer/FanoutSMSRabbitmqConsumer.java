package com.study.rabbitmqservice.consumer;

import com.rabbitmq.client.*;
import com.study.rabbitmqservice.consumer.config.ConnectionUtil;

import java.io.IOException;

/**
 * @author： leon
 * @date： 2020/11/14 15:15
 * @description： TODO
 * @modifiedBy：
 * @version: 1.0
 */
public class FanoutSMSRabbitmqConsumer {

    public static void main(String[] args) throws Exception {
        System.out.println("短信消费者启动");
        Connection connection = ConnectionUtil.getConnection();
        Channel channel = connection.createChannel();
        String queueName = "fanout-smsQueue";
        AMQP.Queue.DeclareOk queue = channel.queueDeclare(queueName, false, false, false, null);
        channel.queueBind(queueName,"fanout-exchange-name","");
        DefaultConsumer consumer = new DefaultConsumer(channel) {
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                String msg = new String(body, "utf-8");
                System.out.println("短信消费者获取消息：" + msg);
            }
        };
        channel.basicConsume(queueName,true,consumer);

    }

}
