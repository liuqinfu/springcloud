package com.study.springbootsecurity.entity;

import java.io.Serializable;

/**
 * (SysUserRole)实体类
 *
 * @author makejava
 * @since 2020-11-21 15:59:58
 */
public class SysUserRole implements Serializable {
    private static final long serialVersionUID = -99878313709683920L;

    private Integer userId;

    private Integer roleId;


    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

}