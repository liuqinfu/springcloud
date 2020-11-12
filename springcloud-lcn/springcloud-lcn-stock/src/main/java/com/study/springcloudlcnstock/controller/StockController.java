package com.study.springcloudlcnstock.controller;

import com.study.springcloudlcnstock.entity.Stock;
import com.study.springcloudlcnstock.service.StockService;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * (Stock)表控制层
 *
 * @author makejava
 * @since 2020-11-11 23:14:38
 */
@RestController
@RequestMapping("stock")
public class StockController implements com.study.springcloudlcnapistock.service.StockService {
    /**
     * 服务对象
     */
    @Resource
    private StockService stockService;




    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Stock selectOne(Integer id) {
        return this.stockService.queryById(id);
    }

    @DeleteMapping("stock")
    @Override
    public boolean deleteStock() {
        Stock stock = this.stockService.queryById(1);
        stock.setStock(stock.getStock()-1);
        this.stockService.update(stock);
        return true;
    }
}