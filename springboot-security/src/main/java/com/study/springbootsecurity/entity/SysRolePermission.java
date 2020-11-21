package com.study.springbootsecurity.entity;

import java.io.Serializable;

/**
 * (SysRolePermission)实体类
 *
 * @author makejava
 * @since 2020-11-21 15:59:52
 */
public class SysRolePermission implements Serializable {
    private static final long serialVersionUID = 346316128694193079L;

    private Integer roleId;

    private Integer permId;


    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getPermId() {
        return permId;
    }

    public void setPermId(Integer permId) {
        this.permId = permId;
    }

}