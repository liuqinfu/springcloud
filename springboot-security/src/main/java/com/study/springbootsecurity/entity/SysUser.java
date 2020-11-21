package com.study.springbootsecurity.entity;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * (SysUser)实体类
 *
 * @author makejava
 * @since 2020-11-21 15:59:56
 */
@Data
public class SysUser implements Serializable, UserDetails {
    private static final long serialVersionUID = -99736007763889122L;

    private Integer id;

    private String username;

    private String realname;

    private String password;

    private Date createDate;

    private Date lastLoginTime;

    private boolean enabled;

    private boolean accountNonExpired;

    private boolean accountNonLocked;

    private boolean credentialsNonExpired;

    //用户所有权限
    private List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }


}