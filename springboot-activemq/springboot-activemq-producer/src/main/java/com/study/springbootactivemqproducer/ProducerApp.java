package com.study.springbootactivemqproducer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author： leon
 * @date： 2020/11/10 21:07
 * @description： TODO
 * @modifiedBy：
 * @version: 1.0
 */
@SpringBootApplication
@EnableScheduling
public class ProducerApp {

    public static void main(String[] args) {
        SpringApplication.run(ProducerApp.class);
    }
}
