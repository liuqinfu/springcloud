package com.study.springbootes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

/**
 * @author： leon
 * @date： 2020/11/23 15:39
 * @description： TODO
 * @modifiedBy：
 * @version: 1.0
 */
@SpringBootApplication
@EnableElasticsearchRepositories(basePackages = "com.study.springbootes.esdao")
public class ESApp {

    public static void main(String[] args) {
        SpringApplication.run(ESApp.class);
    }
}
