package com.study.springcloudlcnorder.entity;

import java.io.Serializable;

/**
 * (Order)实体类
 *
 * @author makejava
 * @since 2020-11-11 22:37:37
 */
public class Order implements Serializable {
    private static final long serialVersionUID = 284055566559132970L;

    private Integer id;
    /**
     * 商品名
     */
    private String name;
    /**
     * 订单状态：1-待支付  0-未支付
     */
    private Integer status;
    /**
     * 订单金额
     */
    private Double mount;
    /**
     * 商品id
     */
    private Integer goodId;


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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Double getMount() {
        return mount;
    }

    public void setMount(Double mount) {
        this.mount = mount;
    }

    public Integer getGoodId() {
        return goodId;
    }

    public void setGoodId(Integer goodId) {
        this.goodId = goodId;
    }

}