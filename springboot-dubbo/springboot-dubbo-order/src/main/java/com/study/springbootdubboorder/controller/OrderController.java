package com.study.springbootdubboorder.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.study.springbootdubbo.api.MemberService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 我走路带风
 * @since 2020/11/9 17:13
 */
@RestController("order")
public class OrderController {


    @Reference
    public MemberService memberService;

    @GetMapping("order")
    public String getOrder(String userId){
        String member = memberService.getMember(userId);
        return "订单服务响应。"+member;
    }

}
