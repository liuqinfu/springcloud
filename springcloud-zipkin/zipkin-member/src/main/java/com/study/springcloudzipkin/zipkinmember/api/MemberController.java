package com.study.springcloudzipkin.zipkinmember.api;

import com.study.springcloudzipkin.zipkinapimember.MemberService;
import com.study.springcloudzipkin.zipkinapiorder.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author： leon
 * @date： 2020/12/1 00:56
 * @description： TODO
 * @modifiedBy：
 * @version: 1.0
 */
@RestController
@RequestMapping("member")
public class MemberController implements MemberService {

    @Autowired
    private OrderService orderService;

    @Override
    @RequestMapping("member/{memberId}")
    public String getMemberById(@PathVariable String memberId) {
        orderService.createOrder(memberId);
        return "会员创建订单成功";
    }
}
