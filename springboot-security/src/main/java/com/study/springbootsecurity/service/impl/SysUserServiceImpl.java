package com.study.springbootsecurity.service.impl;

import com.study.springbootsecurity.dao.SysUserDao;
import com.study.springbootsecurity.entity.SysPermission;
import com.study.springbootsecurity.entity.SysUser;
import com.study.springbootsecurity.service.SysUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (SysUser)表服务实现类
 *
 * @author makejava
 * @since 2020-11-21 15:59:57
 */
@Service("sysUserService")
public class SysUserServiceImpl implements SysUserService {
    @Resource
    private SysUserDao sysUserDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public SysUser queryById(Integer id) {
        return this.sysUserDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<SysUser> queryAllByLimit(int offset, int limit) {
        return this.sysUserDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param sysUser 实例对象
     * @return 实例对象
     */
    @Override
    public SysUser insert(SysUser sysUser) {
        this.sysUserDao.insert(sysUser);
        return sysUser;
    }

    /**
     * 修改数据
     *
     * @param sysUser 实例对象
     * @return 实例对象
     */
    @Override
    public SysUser update(SysUser sysUser) {
        this.sysUserDao.update(sysUser);
        return this.queryById(sysUser.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.sysUserDao.deleteById(id) > 0;
    }


    /**
     * 通过登录名查询用户信息
     * @param userName  登录用户名
     * @return
     */
    @Override
    public SysUser findByName(String userName){
        System.out.println("登录一次就查询一次");
        return this.sysUserDao.findByName(userName);
    }

    /**
     * 查询用户所有权限
     * @param userName 登录用户名
     * @return
     */
    @Override
    public List<SysPermission> findPermissionsByUserName(String userName){
        return this.sysUserDao.findPermissionsByUserName(userName);
    }
}