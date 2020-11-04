package com.study.configclient.api.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author： leon
 * @date： 2020/11/4 22:20
 * @description： TODO
 * @modifiedBy：
 * @version: 1.0
 */
@RestController
@RefreshScope
@RequestMapping("config")
public class TestController {

    @Value("${user.name}")
    private String name;


    @GetMapping("name")
    public String getName(){
        return name;
    }
}
