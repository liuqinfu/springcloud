package com.study.springcloudlcnorder.service.impl;

import com.study.springcloudlcnapistock.service.StockService;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @author： leon
 * @date： 2020/11/12 23:08
 * @description： TODO
 * @modifiedBy：
 * @version: 1.0
 */
@FeignClient(name = "springcloud-lcn-stock")
public interface StockServiceImpl extends StockService {
}
