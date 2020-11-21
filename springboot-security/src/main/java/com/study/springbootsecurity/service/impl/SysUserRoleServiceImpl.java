package com.study.springbootsecurity.service.impl;

import com.study.springbootsecurity.dao.SysUserRoleDao;
import com.study.springbootsecurity.entity.SysUserRole;
import com.study.springbootsecurity.service.SysUserRoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (SysUserRole)表服务实现类
 *
 * @author makejava
 * @since 2020-11-21 16:00:00
 */
@Service("sysUserRoleService")
public class SysUserRoleServiceImpl implements SysUserRoleService {
    @Resource
    private SysUserRoleDao sysUserRoleDao;

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<SysUserRole> queryAllByLimit(int offset, int limit) {
        return this.sysUserRoleDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param sysUserRole 实例对象
     * @return 实例对象
     */
    @Override
    public SysUserRole insert(SysUserRole sysUserRole) {
        this.sysUserRoleDao.insert(sysUserRole);
        return sysUserRole;
    }

}