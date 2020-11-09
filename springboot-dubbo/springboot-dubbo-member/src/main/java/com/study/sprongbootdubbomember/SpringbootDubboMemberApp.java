package com.study.sprongbootdubbomember;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author 我走路带风
 * @since 2020/11/9 17:03
 */
@SpringBootApplication
@EnableDubbo
public class SpringbootDubboMemberApp {
    public static void main(String[] args) {
        SpringApplication.run(SpringbootDubboMemberApp.class);
    }
}
