package com.study.springcloudlcnapistock.service;

import org.springframework.web.bind.annotation.DeleteMapping;

/**
 * @author： leon
 * @date： 2020/11/12 22:38
 * @description： TODO
 * @modifiedBy：
 * @version: 1.0
 */
public interface StockService {

    @DeleteMapping("stock/stock")
    public boolean deleteStock();

}
