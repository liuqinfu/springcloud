package com.study.configcenter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @author： leon
 * @date： 2020/11/4 19:04
 * @description： TODO
 * @modifiedBy：
 * @version: 1.0
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableConfigServer
public class ConfigApp {

    public static void main(String[] args) {
        SpringApplication.run(ConfigApp.class);
    }
}
