package com.study.zuulorder.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 我走路带风
 * @since 2020/11/6 10:01
 */
@RestController
@RequestMapping("order")
public class OrderController {

    @GetMapping("order")
    public String getOrder(){
        return "这是订单服务";
    }
}
