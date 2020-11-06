package com.study.zuulorder.api;

import com.spring4all.swagger.EnableSwagger2Doc;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 我走路带风
 * @since 2020/11/6 10:01
 */
@RestController
@RequestMapping("order")
@EnableSwagger2Doc
@Api("订单服务")
public class OrderController {

    @ApiOperation("获取订单")
    @GetMapping("order")
    public String getOrder(){
        return "这是订单服务";
    }
}
