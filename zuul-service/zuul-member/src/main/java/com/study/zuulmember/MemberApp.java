package com.study.zuulmember;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author 我走路带风
 * @since 2020/11/6 9:14
 */
@SpringBootApplication
@EnableDiscoveryClient
public class MemberApp {
    public static void main(String[] args) {
        SpringApplication.run(MemberApp.class);
    }
}
