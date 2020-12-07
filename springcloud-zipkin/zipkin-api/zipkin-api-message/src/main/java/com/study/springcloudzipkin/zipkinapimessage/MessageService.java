package com.study.springcloudzipkin.zipkinapimessage;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

/**
 * @author： leon
 * @date： 2020/12/1 00:48
 * @description： TODO
 * @modifiedBy：
 * @version: 1.0
 */
public interface MessageService {

    /**
     * 发送订单详情
     * @param order
     * @return
     */
    @PostMapping("msg/msg")
    String sendMessage(@RequestBody Map order);
}
