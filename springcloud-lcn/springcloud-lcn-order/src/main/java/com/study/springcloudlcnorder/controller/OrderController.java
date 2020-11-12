package com.study.springcloudlcnorder.controller;

import com.study.springcloudlcnorder.entity.Order;
import com.study.springcloudlcnorder.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * (Order)表控制层
 *
 * @author makejava
 * @since 2020-11-11 22:37:42
 */
@RestController
@RequestMapping("order")
public class OrderController {
    /**
     * 服务对象
     */
    @Resource
    private OrderService orderService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Order selectOne(Integer id) {
        return this.orderService.queryById(id);
    }

}