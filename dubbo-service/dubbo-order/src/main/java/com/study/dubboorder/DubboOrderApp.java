package com.study.dubboorder;

import com.study.dubboapimember.MemberService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author 我走路带风
 * @since 2020/11/9 13:55
 */
public class DubboOrderApp {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("order-consumer.xml");
        MemberService memberService = (MemberService) context.getBean("memberService");
        String member = memberService.getMember("110");
        System.out.println(member);

    }
}
