package com.study.rabbitmqservice.producer.config;


import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @author： leon
 * @date： 2020/11/14 10:12
 * @description： TODO
 * @modifiedBy：
 * @version: 1.0
 */
public class ConnectionUtil {

    public static Connection getConnection() throws IOException, TimeoutException {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("127.0.0.1");
        factory.setPort(5672);
        factory.setUsername("admin");
        factory.setPassword("admin");
        factory.setVirtualHost("admin");
        return factory.newConnection();
    }
}
