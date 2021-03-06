package com.study.springbootrabbitmqconsumer.consumers;

import com.alibaba.fastjson.JSONObject;
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
public class EmailConsumer {

    @RabbitListener(queues = {"email-queue"})
    @RabbitHandler
    public void process(Message message, @Headers Map<String, Object> headers, Channel channel) throws IOException {
        // 获取消息唯一标识 解决消息幂等性问题
        String messageId = message.getMessageProperties().getMessageId();
        String msgStr = new String(message.getBody(), "utf-8");
        JSONObject jsonObject = JSONObject.parseObject(msgStr);
        String arg = jsonObject.getString("timestamp");
        System.out.println("邮件消费者收到消息："+msgStr+"消息ID："+messageId);
        Long deliveryTag = (Long) headers.get(AmqpHeaders.DELIVERY_TAG);
        try {
            int i = 1/Integer.valueOf(arg);
            System.out.println("邮件消费者消费消息："+msgStr+"消息ID："+messageId);
            // 手动ACK
            // 手动签收
            channel.basicAck(deliveryTag,false);
        } catch (Exception e) {
            e.printStackTrace();
            //拒绝消息  把消息丢给死信队列
            channel.basicNack(deliveryTag,false,false);
        }
    }
}
