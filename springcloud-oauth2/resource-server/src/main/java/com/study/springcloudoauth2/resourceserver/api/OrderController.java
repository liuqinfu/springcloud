package com.study.springcloudoauth2.resourceserver.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author： leon
 * @date： 2020/11/22 10:22
 * @description： TODO
 * @modifiedBy：
 * @version: 1.0
 */
@RestController
@RequestMapping("api")
public class OrderController {

    @GetMapping("order")
    public String getOrder(){
        return "order";
    }
}
