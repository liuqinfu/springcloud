package com.study.apimember.service;

import com.study.apimember.entity.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author 我走路带风
 * @since 2020/11/3 16:04
 */
public interface MemberService {

    /**
     * 根据用户id获取用户信息
     * @param userId
     * @return
     */
    @PostMapping("mem/user")
    public User getUser(@RequestParam String userId);

}
