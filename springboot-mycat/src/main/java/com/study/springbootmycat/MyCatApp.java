package com.study.springbootmycat;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author： leon
 * @date： 2020/11/30 00:55
 * @description： TODO
 * @modifiedBy：
 * @version: 1.0
 */
@SpringBootApplication
@MapperScan(basePackages = "com.study.springbootmycat.dao")
public class MyCatApp {

    public static void main(String[] args) {
        SpringApplication.run(MyCatApp.class);
    }
}
