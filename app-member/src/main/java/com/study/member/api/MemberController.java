package com.study.member.api;

import com.study.apimember.entity.User;
import com.study.apimember.service.MemberService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 我走路带风
 * @since 2020/11/2 15:27
 */
@RestController
@RequestMapping("mem")
public class MemberController implements MemberService {


    @Value("${server.port}")
    private String port;

    @PostMapping("user")
    public User getUser(@RequestParam String userId) {
        User user = new User().setId(userId).setAge(26).setName("liuqf").setPort(port);
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return user;
    }
}
