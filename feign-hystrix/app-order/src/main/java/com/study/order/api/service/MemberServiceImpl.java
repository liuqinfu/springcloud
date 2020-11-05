package com.study.order.api.service;

import com.study.apimember.service.MemberService;
import com.study.order.api.fallback.MemberFallBack;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author 我走路带风
 * @since 2020/11/3 16:34
 */

@FeignClient(name = "app-member",fallback = MemberFallBack.class)
public interface MemberServiceImpl extends MemberService {
}
