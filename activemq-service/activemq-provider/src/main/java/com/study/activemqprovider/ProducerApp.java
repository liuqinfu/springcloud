package com.study.activemqprovider;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * @author： leon
 * @date： 2020/11/9 22:50
 * @description： TODO
 * @modifiedBy：
 * @version: 1.0
 */
public class ProducerApp {


    static String brokerUrl = "tcp://127.0.0.1:61616";

    public static void main(String[] args) throws Exception {
        //1 创建连接工厂  密码采用默认密码
        ActiveMQConnectionFactory factory = new ActiveMQConnectionFactory(brokerUrl);
        //2 创建连接
        Connection connection = factory.createConnection();
        //3 创建会话  参数一：是否以事务的方式提交   参数二：消息签收方式
        connection.start();
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        //4 创建目标队列
//        Queue queue = session.createQueue("myqueue");
        Topic mytopic = session.createTopic("mytopic");
        //5 创建生产者
//        MessageProducer producer = session.createProducer(queue);
        MessageProducer producer = session.createProducer(mytopic);
        //6 创建消息
        for (int i = 0; i < 10; i++) {
            TextMessage message = session.createTextMessage("消息内容:" + i);
            //7 提交消息
            producer.send(message);
        }
        //8 关闭连接
        connection.close();


    }
}
