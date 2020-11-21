package com.study.springbootsecurity;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author： leon
 * @date： 2020/11/20 22:42
 * @description： TODO
 * @modifiedBy：
 * @version: 1.0
 */
@SpringBootApplication
@MapperScan(basePackages = {"com.study.springbootsecurity.dao"})
public class SecurityApp {

    public static void main(String[] args) {
        SpringApplication.run(SecurityApp.class);
    }
}
