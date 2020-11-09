package com.study.dubbomember.service.impl;

import com.study.dubboapimember.MemberService;

/**
 * @author 我走路带风
 * @since 2020/11/9 11:04
 */
public class MemberServiceImpl implements MemberService {
    @Override
    public String getMember(String id) {
        return "会员服务：会员id："+id;
    }
}
