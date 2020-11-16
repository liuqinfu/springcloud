package com.study.springbootrabbitmqconsumer.consumers;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Map;

/**
 * @author： leon
 * @date： 2020/11/15 22:25
 * @description： TODO
 * @modifiedBy：
 * @version: 1.0
 */
@Component
@RabbitListener(queues = {"sms-queue"})
public class SmsConsumer {

    @RabbitHandler
    public void process(Message message, @Headers Map<String, Object> headers, Channel channel) throws IOException {
        // 获取消息唯一标识 解决消息幂等性问题
        String messageId = message.getMessageProperties().getMessageId();
        String msg = new String(message.getBody(), "utf-8");
        System.out.println("短信消费者消费消息："+msg+"消息ID："+messageId);
        // 手动ACK
        Long deliveryTag = (Long) headers.get(AmqpHeaders.DELIVERY_TAG);
        // 手动签收
        channel.basicAck(deliveryTag,false);
        System.out.println("短信消费者消费消息："+msg);
    }
}
