package com.study.springbootsecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author： leon
 * @date： 2020/11/20 22:43
 * @description： TODO
 * @modifiedBy：
 * @version: 1.0
 */
@Controller
//@RequestMapping("page")
public class PageController {

    @RequestMapping("login")
    public String login(){
        return "login";
    }

    @GetMapping("index")
    public String index(){
        return "index";
    }

    @GetMapping("show")
    public String show(){
        return "show";
    }
    @GetMapping("add")
    public String add(){
        return "add";
    }
    @GetMapping("update")
    public String update(){
        return "update";
    }
    @GetMapping("delete")
    public String delete(){
        return "delete";
    }

}
