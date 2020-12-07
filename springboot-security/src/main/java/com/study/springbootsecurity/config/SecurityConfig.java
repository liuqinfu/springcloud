package com.study.springbootsecurity.config;

import com.study.springbootsecurity.entity.SysPermission;
import com.study.springbootsecurity.security.MineUserDetailService;
import com.study.springbootsecurity.service.SysPermissionService;
import com.study.springbootsecurity.utils.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;

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

    @Autowired
    private MineUserDetailService mineUserDetailService;

    @Autowired
    private SysPermissionService sysPermissionService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        /*auth.inMemoryAuthentication().withUser("admin").password("admin").authorities("showOrder","addOrder","updateOrder","deleteOrder");
        auth.inMemoryAuthentication().withUser("liuqf").password("liuqf").authorities("showOrder","addOrder");*/
//        数据库动态加载用户
        auth.userDetailsService(mineUserDetailService).passwordEncoder(new PasswordEncoder() {
            //对表单密码进行加密
            @Override
            public String encode(CharSequence charSequence) {
                return MD5Util.encode(charSequence.toString());
            }

            //加密的密码与数据库密码进行比对
            @Override
            public boolean matches(CharSequence charSequence, String encodedPassword) {
                return encodedPassword.equals(MD5Util.encode(charSequence.toString()));
            }
        });
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests().antMatchers("/**").fullyAuthenticated().and().httpBasic();
        /*HttpSecurity disable = http.authorizeRequests()
                .antMatchers("/login").permitAll()
                .antMatchers("/static/**").permitAll()
                .antMatchers("/show").hasAuthority("showOrder")
                .antMatchers("/add").hasAuthority("addOrder")
                .antMatchers("/update").hasAuthority("updateOrder")
                .antMatchers("/delete").hasAuthority("deleteOrder")
                .antMatchers("/**").fullyAuthenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .successHandler(successResultHandler)
                .failureHandler(failResultHandler)
                .and()
                .csrf().disable();*/

        //动态设置权限
        ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry authorizeRequests = http.authorizeRequests();
        List<SysPermission> sysPermissions = sysPermissionService.queryAll(null);
        sysPermissions.stream().forEach(permission->{
            authorizeRequests.antMatchers(permission.getUrl()).hasAnyAuthority(permission.getPermtag());
        });
        authorizeRequests. antMatchers("/login").permitAll()
                .antMatchers("/static/**").permitAll()
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
