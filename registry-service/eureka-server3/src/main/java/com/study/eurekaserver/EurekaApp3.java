package com.study.eurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author 我走路带风
 * @since 2020/11/4 16:02
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaApp3 {
    public static void main(String[] args) {
        SpringApplication.run(EurekaApp3.class);
    }
}
