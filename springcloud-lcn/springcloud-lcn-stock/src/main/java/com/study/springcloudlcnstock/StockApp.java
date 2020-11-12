package com.study.springcloudlcnstock;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author： leon
 * @date： 2020/11/12 23:01
 * @description： TODO
 * @modifiedBy：
 * @version: 1.0
 */
@SpringBootApplication
@EnableEurekaClient
public class StockApp {
    public static void main(String[] args) {
        SpringApplication.run(StockApp.class);
    }

}
