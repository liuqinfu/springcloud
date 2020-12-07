package com.study.springcloudzipkin.zipkinapimember;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author： leon
 * @date： 2020/12/1 00:40
 * @description： TODO
 * @modifiedBy：
 * @version: 1.0
 */
public interface MemberService {

    /**
     * 根据会员id获取会员信息
     * @param memberId
     * @return
     */
    @RequestMapping("member/member/{memberId}")
    String getMemberById(@PathVariable String memberId);
}
