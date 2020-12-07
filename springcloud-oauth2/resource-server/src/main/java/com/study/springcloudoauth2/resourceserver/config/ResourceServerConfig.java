package com.study.springcloudoauth2.resourceserver.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

/**
 * @author： leon
 * @date： 2020/11/22 10:33
 * @description： TODO
 * @modifiedBy：
 * @version: 1.0
 */
@Configuration
@EnableResourceServer //开启资源服务中心
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {
    @Override
    public void configure(HttpSecurity http) throws Exception {
        //对api/order进行拦截，验证accesstoken
        http.authorizeRequests().antMatchers("/api/**").authenticated();
    }
}
