package com.study.springbootsecurity.service.impl;

import com.study.springbootsecurity.dao.SysRolePermissionDao;
import com.study.springbootsecurity.entity.SysRolePermission;
import com.study.springbootsecurity.service.SysRolePermissionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (SysRolePermission)表服务实现类
 *
 * @author makejava
 * @since 2020-11-21 15:59:54
 */
@Service("sysRolePermissionService")
public class SysRolePermissionServiceImpl implements SysRolePermissionService {
    @Resource
    private SysRolePermissionDao sysRolePermissionDao;


    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<SysRolePermission> queryAllByLimit(int offset, int limit) {
        return this.sysRolePermissionDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param sysRolePermission 实例对象
     * @return 实例对象
     */
    @Override
    public SysRolePermission insert(SysRolePermission sysRolePermission) {
        this.sysRolePermissionDao.insert(sysRolePermission);
        return sysRolePermission;
    }


}