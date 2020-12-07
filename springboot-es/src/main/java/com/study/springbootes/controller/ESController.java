package com.study.springbootes.controller;

import com.study.springbootes.document.User;
import com.study.springbootes.esdao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * @author： leon
 * @date： 2020/11/23 15:52
 * @description： TODO
 * @modifiedBy：
 * @version: 1.0
 */
@RestController
@RequestMapping("es/users")
public class ESController {

    @Autowired
    private UserDao userDao;

    @GetMapping("user/{id}")
    public User getUser(@PathVariable String id){
        Optional<User> userOptional = userDao.findById(id);
        User user = Optional.ofNullable(userOptional).get().orElse(null);
        return user;
    }

    @PutMapping("user")
    public User saveUser(@RequestBody User user){
        User userReturn = userDao.save(user);
        return userReturn;
    }
}
