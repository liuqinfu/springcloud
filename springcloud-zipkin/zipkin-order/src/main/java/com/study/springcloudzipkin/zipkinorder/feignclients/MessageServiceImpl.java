package com.study.springcloudzipkin.zipkinorder.feignclients;

import com.study.springcloudzipkin.zipkinapimessage.MessageService;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author： leon
 * @date： 2020/12/1 01:00
 * @description： TODO
 * @modifiedBy：
 * @version: 1.0
 */
@FeignClient("zipkin-message")
public interface MessageServiceImpl extends MessageService {
}
