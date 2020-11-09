package com.study.sprongbootdubbomember.services.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.study.springbootdubbo.api.MemberService;

/**
 * @author 我走路带风
 * @since 2020/11/9 16:52
 */
@Service  //使用dubbo提供的Service注解发布服务
public class MemberServiceImpl implements MemberService {

    @Override
    public String getMember(String id) {
        return "会员服务，会员信息："+id;
    }
}
