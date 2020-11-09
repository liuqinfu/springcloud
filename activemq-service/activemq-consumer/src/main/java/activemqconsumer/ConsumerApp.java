package activemqconsumer;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * @author： leon
 * @date： 2020/11/9 22:50
 * @description： TODO
 * @modifiedBy：
 * @version: 1.0
 */
public class ConsumerApp {


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
        //5 创建消费者
//        MessageConsumer consumer = session.createConsumer(queue);
        MessageConsumer consumer = session.createConsumer(mytopic);
        consumer.setMessageListener(new MessageListener() {
            @lombok.SneakyThrows
            @Override
            public void onMessage(Message message) {
                TextMessage textMessage = (TextMessage) message;
                System.out.println("消费者消费到消息："+textMessage.getText());
            }
        });


    }
}
