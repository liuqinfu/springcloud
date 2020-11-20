package com.study.springbootsecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author： leon
 * @date： 2020/11/20 23:37
 * @description： TODO
 * @modifiedBy：
 * @version: 1.0
 */
@Controller
public class ErrorController {

    @GetMapping("error/{status}")
    public String error(@PathVariable String status){
        return "/error/"+status;
    }
}
