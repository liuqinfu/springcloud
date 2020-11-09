package com.study.springbootdubbo.api;

/**
 * @author 我走路带风
 * @since 2020/11/9 16:50
 */
public interface MemberService {

    /**
     * 通过id获取会员信息
     * @param id
     * @return
     */
    public String getMember(String id);
}
