package com.study.dubbomember;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * @author 我走路带风
 * @since 2020/11/9 11:43
 */
public class DubboMemberApp {

    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("dubbo-provider.xml");
        context.start();
        System.out.println("member服务启动");
        System.in.read();
    }
}
