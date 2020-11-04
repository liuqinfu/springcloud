package com.study.eurekaorder.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author 我走路带风
 * @since 2020/11/4 16:43
 */
@RestController
@RequestMapping("order")
public class OrderController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("order/{id}")
    public String getOrder(@PathVariable String id){
        String memberResp = restTemplate.getForObject("http://eureka-member/mem/mem?id=" + id, String.class);
        return "这是订单服务，调用的会员服务结果为："+memberResp;
    }
}
