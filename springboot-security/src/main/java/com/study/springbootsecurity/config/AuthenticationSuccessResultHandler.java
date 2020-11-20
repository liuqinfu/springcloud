package com.study.springbootsecurity.config;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author： leon
 * @date： 2020/11/21 00:47
 * @description： TODO
 * @modifiedBy：
 * @version: 1.0
 */
@Component
public class AuthenticationSuccessResultHandler implements AuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        System.out.println("认证成功");
        httpServletResponse.sendRedirect("/index");
    }
}
