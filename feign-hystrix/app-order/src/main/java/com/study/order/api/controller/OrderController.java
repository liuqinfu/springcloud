package com.study.order.api.controller;

import com.apiorder.OrderService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.study.apimember.entity.User;
import com.study.apimember.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 我走路带风
 * @since 2020/11/2 15:33
 */
@RestController
@RequestMapping("order")
public class OrderController implements OrderService {

    @Autowired
    private MemberService memberService;

    //该接口使用hystrix，且指定了降级方法   该注解方式会将整个方法加入到线程中，不推荐使用，正常应该讲远程调用代码块放入线程中
    @HystrixCommand(fallbackMethod = "defaultReturn")
    @GetMapping("order/{userId}")
    public Map getOrder(@PathVariable String userId){
        User user = memberService.getUser(userId);
        Map order = new HashMap();
        order.put("orderId",110);
        order.put("item","iPhone12ProMax");
        order.put("buyer",user);
        return order;
    }

    /**
     * 采用类的方式进行服务降级 (推荐使用)
     * @param userId
     * @return
     */
    @GetMapping("order/v2/{userId}")
    public Map getOrderV2(@PathVariable String userId){
        User user = memberService.getUser(userId);
        Map order = new HashMap();
        order.put("orderId",110);
        order.put("item","iPhone12ProMax");
        order.put("buyer",user);
        return order;
    }

    public Map defaultReturn(String userId){
        Map res = new HashMap();
        res.put("msg","订单服务降级，此默认返回");
        return res;
    }
}
