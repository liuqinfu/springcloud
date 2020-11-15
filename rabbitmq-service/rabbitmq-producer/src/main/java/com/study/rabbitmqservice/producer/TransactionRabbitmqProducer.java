package com.study.rabbitmqservice.producer;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.study.rabbitmqservice.producer.config.ConnectionUtil;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/** 事务机制保证生产者将消息发送到mq
 * @author： leon
 * @date： 2020/11/14 10:19
 * @description： TODO
 * @modifiedBy：
 * @version: 1.0
 */
public class TransactionRabbitmqProducer {

    public static void main(String[] args) throws IOException, TimeoutException {
        Connection connection = ConnectionUtil.getConnection();
        Channel channel = connection.createChannel();
        channel.queueDeclare("adminqueue", false, false, false, null);
        channel.basicQos(1);
        try {
            channel.txSelect();//开启事务
            String msg="first rabbitmq message";
            channel.basicPublish("","adminqueue",null,msg.getBytes());
            System.out.println("生产者发送消息："+msg);
            int a =1/0;
            channel.txCommit();//提交事务
        } catch (IOException e) {
            channel.txRollback();//回滚事务
        } finally {
            channel.close();
            connection.close();
        }

    }
}
