package com.study.springcloudlcneureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author： leon
 * @date： 2020/11/12 22:35
 * @description： TODO
 * @modifiedBy：
 * @version: 1.0
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaApp {

    public static void main(String[] args) {
        SpringApplication.run(EurekaApp.class);
    }
}
