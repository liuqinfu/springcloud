package com.study.springbootshardingjdbc;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author： leon
 * @date： 2020/11/30 14:59
 * @description： TODO
 * @modifiedBy：
 * @version: 1.0
 */
@SpringBootApplication
@MapperScan(basePackages = "com.study.springbootshardingjdbc.dao")
public class ShardingJdbcApp {

    public static void main(String[] args) {
        SpringApplication.run(ShardingJdbcApp.class);
    }

}
