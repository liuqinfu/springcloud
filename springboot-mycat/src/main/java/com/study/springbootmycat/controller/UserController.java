package com.study.springbootmycat.controller;

import com.study.springbootmycat.entity.User;
import com.study.springbootmycat.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * (User)表控制层
 *
 * @author makejava
 * @since 2020-11-30 01:01:24
 */
@RestController
@RequestMapping("user")
public class UserController {
    /**
     * 服务对象
     */
    @Resource
    private UserService userService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public User selectOne(String id) {
        return this.userService.queryById(id);
    }

    @GetMapping("rename")
    public User renameUser(String id,String newName){
        User user = this.userService.queryById(id);
        user.setName(newName);
        User update = this.userService.update(user);
        return update;
    }

}