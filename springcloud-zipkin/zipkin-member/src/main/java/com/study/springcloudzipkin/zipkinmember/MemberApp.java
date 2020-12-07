package com.study.springcloudzipkin.zipkinmember;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author： leon
 * @date： 2020/12/1 00:30
 * @description： TODO
 * @modifiedBy：
 * @version: 1.0
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages = "com.study.springcloudzipkin.zipkinmember.feignclients")
public class MemberApp {

    public static void main(String[] args) {
        SpringApplication.run(MemberApp.class);
    }
}
