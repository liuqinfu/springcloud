package com.study.springcloudzipkin.zipkinmessage.api;

import com.alibaba.fastjson.JSONObject;
import com.study.springcloudzipkin.zipkinapimessage.MessageService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author： leon
 * @date： 2020/12/1 01:04
 * @description： TODO
 * @modifiedBy：
 * @version: 1.0
 */
@RestController
@RequestMapping("msg")
public class MessageController implements MessageService {

    @Override
    @PostMapping("msg")
    public String sendMessage(@RequestBody Map order) {
        System.out.println("订单通知："+ JSONObject.toJSONString(order));
        return "消息发送成功";
    }
}
