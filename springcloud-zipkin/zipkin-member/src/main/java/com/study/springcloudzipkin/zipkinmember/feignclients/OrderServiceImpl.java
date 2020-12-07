package com.study.springcloudzipkin.zipkinmember.feignclients;

import com.study.springcloudzipkin.zipkinapiorder.OrderService;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author： leon
 * @date： 2020/12/1 00:54
 * @description： TODO
 * @modifiedBy：
 * @version: 1.0
 */
@FeignClient("zipkin-order")
public interface OrderServiceImpl extends OrderService {
}
