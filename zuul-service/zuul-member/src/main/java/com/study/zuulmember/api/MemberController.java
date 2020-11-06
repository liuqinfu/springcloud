package com.study.zuulmember.api;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 我走路带风
 * @since 2020/11/6 9:15
 */
@RestController
@RequestMapping("member")
public class MemberController {

    @Value("${server.port}")
    private String port;

    @GetMapping("member")
    public String getMember(){
        return "这是会员服务"+port;
    }
}
