package com.study.springbootsecurity.entity;

import java.io.Serializable;

/**
 * (SysRole)实体类
 *
 * @author makejava
 * @since 2020-11-21 15:59:49
 */
public class SysRole implements Serializable {
    private static final long serialVersionUID = -74326695670011100L;

    private Integer id;

    private String rolename;

    private String roledesc;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    public String getRoledesc() {
        return roledesc;
    }

    public void setRoledesc(String roledesc) {
        this.roledesc = roledesc;
    }

}