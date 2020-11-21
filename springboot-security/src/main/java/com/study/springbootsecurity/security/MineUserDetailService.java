package com.study.springbootsecurity.security;

import com.study.springbootsecurity.entity.SysPermission;
import com.study.springbootsecurity.entity.SysUser;
import com.study.springbootsecurity.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/** 设置动态用户信息
 * @author： leon
 * @date： 2020/11/21 16:34
 * @description： TODO
 * @modifiedBy：
 * @version: 1.0
 */
@Service
public class MineUserDetailService implements UserDetailsService {

    @Autowired
    private SysUserService sysUserService;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        //1 根据用户名查询用户信息
        //2 底层会根据数据库的查询信息判断密码是否正确
        SysUser sysUser = sysUserService.findByName(s);
        if (sysUser != null){
            List<SysPermission> permissionsByUserName = sysUserService.findPermissionsByUserName(s);
            if (permissionsByUserName != null && permissionsByUserName.size() >0){
                List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
                permissionsByUserName.stream().forEach(permission->{
                    authorities.add(new SimpleGrantedAuthority(permission.getPermtag()));
                });
                sysUser.setAuthorities(authorities);
            }
        }

        return sysUser;
    }
}
