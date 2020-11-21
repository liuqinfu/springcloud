package com.study.springbootsecurity.service;

import com.study.springbootsecurity.entity.SysPermission;
import com.study.springbootsecurity.entity.SysUser;

import java.util.List;

/**
 * (SysUser)表服务接口
 *
 * @author makejava
 * @since 2020-11-21 15:59:56
 */
public interface SysUserService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    SysUser queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<SysUser> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param sysUser 实例对象
     * @return 实例对象
     */
    SysUser insert(SysUser sysUser);

    /**
     * 修改数据
     *
     * @param sysUser 实例对象
     * @return 实例对象
     */
    SysUser update(SysUser sysUser);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);


    /**
     * 通过登录名查询用户信息
     * @param userName  登录用户名
     * @return
     */
    SysUser findByName(String userName);

    /**
     * 查询用户所有权限
     * @param userName 登录用户名
     * @return
     */
    List<SysPermission> findPermissionsByUserName(String userName);

}