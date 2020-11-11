package com.study.springcloudlcnstock.entity;

import java.io.Serializable;

/**
 * (Stock)实体类
 *
 * @author makejava
 * @since 2020-11-11 23:14:33
 */
public class Stock implements Serializable {
    private static final long serialVersionUID = 424673426086504526L;

    private Integer id;
    /**
     * 商品名称
     */
    private String name;
    /**
     * 库存
     */
    private Long stock;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getStock() {
        return stock;
    }

    public void setStock(Long stock) {
        this.stock = stock;
    }

}