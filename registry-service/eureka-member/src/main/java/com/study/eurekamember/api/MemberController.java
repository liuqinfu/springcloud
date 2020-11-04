package com.study.eurekamember.api;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 我走路带风
 * @since 2020/11/4 16:37
 */
@RestController
@RequestMapping("mem")
public class MemberController {

    @Value("${server.port}")
    private int port;

    @GetMapping("mem")
    public String getMem(@RequestParam String id){
        return "会员服务："+port+"；用户为："+id;
    }

}
