package com.study.springcloudzipkin.zipkinmessage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author： leon
 * @date： 2020/12/1 00:34
 * @description： TODO
 * @modifiedBy：
 * @version: 1.0
 */
@SpringBootApplication
@EnableEurekaClient
public class MessageApp {
    public static void main(String[] args) {
        SpringApplication.run(MessageApp.class);
    }
}
