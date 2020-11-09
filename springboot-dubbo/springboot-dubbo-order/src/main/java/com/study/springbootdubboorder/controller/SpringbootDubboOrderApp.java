package com.study.springbootdubboorder.controller;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author： leon
 * @date： 2020/11/9 23:16
 * @description： TODO
 * @modifiedBy：
 * @version: 1.0
 */
@SpringBootApplication
@EnableDubbo
public class SpringbootDubboOrderApp {
    public static void main(String[] args) {
        SpringApplication.run(SpringbootDubboOrderApp.class);
    }
}
