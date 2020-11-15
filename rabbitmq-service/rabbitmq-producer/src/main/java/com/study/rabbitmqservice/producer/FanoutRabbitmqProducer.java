package com.study.rabbitmqservice.producer;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.study.rabbitmqservice.producer.config.ConnectionUtil;

/**
 * @author： leon
 * @date： 2020/11/14 15:07
 * @description： TODO
 * @modifiedBy：
 * @version: 1.0
 */
public class FanoutRabbitmqProducer {

    public static void main(String[] args) throws Exception {
        Connection connection = ConnectionUtil.getConnection();
        Channel channel = connection.createChannel();
        //参数1：交换机名称  参数2：交换机类型
        String exchange_name = "fanout-exchange-name";
        channel.exchangeDeclare(exchange_name, BuiltinExchangeType.FANOUT);
        String msg="fanoutexchange message";
        channel.basicPublish(exchange_name,"",null,msg.getBytes());
        channel.close();
        connection.close();
    }
}
