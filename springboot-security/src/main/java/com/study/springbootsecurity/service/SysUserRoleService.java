package com.study.springbootsecurity.service;

import com.study.springbootsecurity.entity.SysUserRole;

import java.util.List;

/**
 * (SysUserRole)表服务接口
 *
 * @author makejava
 * @since 2020-11-21 15:59:59
 */
public interface SysUserRoleService {


    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<SysUserRole> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param sysUserRole 实例对象
     * @return 实例对象
     */
    SysUserRole insert(SysUserRole sysUserRole);

}