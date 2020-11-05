package com.study.order.api.fallback;

import com.study.apimember.entity.User;
import com.study.apimember.service.MemberService;
import com.study.order.api.service.MemberServiceImpl;
import org.springframework.stereotype.Component;

/**
 * @author 我走路带风
 * @since 2020/11/5 15:36
 */
@Component
public class MemberFallBack implements MemberServiceImpl {



    @Override
    public User getUser(String userId) {
        return new User().setName("采用类的方式进行服务降级");
    }
}
