package com.study.springcloudzipkin.zipkinapiorder;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;

/**
 * @author： leon
 * @date： 2020/12/1 00:44
 * @description： TODO
 * @modifiedBy：
 * @version: 1.0
 */
public interface OrderService {

    /**
     * 根据会员id生成订单
     * @param memberId
     * @return
     */
    @PutMapping("order/order/bymem/{memberId}")
    String createOrder(@PathVariable String memberId);
}
