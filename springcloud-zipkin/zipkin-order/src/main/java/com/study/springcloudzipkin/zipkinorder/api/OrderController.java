package com.study.springcloudzipkin.zipkinorder.api;

import com.study.springcloudzipkin.zipkinapimessage.MessageService;
import com.study.springcloudzipkin.zipkinapiorder.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author： leon
 * @date： 2020/12/1 01:00
 * @description： TODO
 * @modifiedBy：
 * @version: 1.0
 */
@RestController
@RequestMapping("order")
public class OrderController implements OrderService {

    @Autowired
    private MessageService messageService;

    @Override
    @PutMapping("order/bymem/{memberId}")
    public String createOrder(@PathVariable String memberId) {
        Map order = new HashMap<>();
        order.put("user",memberId);
        order.put("good_name","iPhone 12 mini");
        String s = messageService.sendMessage(order);
        return "订单已通知消息服务";
    }
}
