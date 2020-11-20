package com.study.springbootsecurity.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * @author： leon
 * @date： 2020/11/20 22:59
 * @description： TODO
 * @modifiedBy：
 * @version: 1.0
 */
@Component
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private AuthenticationFailResultHandler failResultHandler;

    @Autowired
    private AuthenticationSuccessResultHandler successResultHandler;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("admin").password("admin").authorities("super","user");
        auth.inMemoryAuthentication().withUser("liuqf").password("liuqf").authorities("user");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests().antMatchers("/**").fullyAuthenticated().and().httpBasic();
        http.authorizeRequests()
                .antMatchers("/login").permitAll()
                .antMatchers("/static/**").permitAll()
                .antMatchers("/show").hasAuthority("user")
                .antMatchers("/add").hasAuthority("user")
                .antMatchers("/update").hasAuthority("super")
                .antMatchers("/delete").hasAuthority("super")
                .antMatchers("/**").fullyAuthenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .successHandler(successResultHandler)
                .failureHandler(failResultHandler)
                .and()
                .csrf().disable();
    }

    @Bean
    public NoOpPasswordEncoder passwordEncoder(){
        return ((NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance());
    }
}
