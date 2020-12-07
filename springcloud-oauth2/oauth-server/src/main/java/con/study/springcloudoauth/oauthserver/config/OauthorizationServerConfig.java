package con.study.springcloudoauth.oauthserver.config;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

/**
 * 授权认证服务中心配置(本地版本)
 *
 * @author： leon
 * @date： 2020/11/22 08:46
 * @description： TODO
 * @modifiedBy：
 * @version: 1.0
 */
//@Configuration
//@EnableAuthorizationServer //开启授权认证服务中心
public class OauthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

    //配置appid  appkey token有效期  回调地址
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory().withClient("client_1")
                .secret(passwordEncoder().encode("123456"))
                .redirectUris("http://www.baidu.com")
                .authorizedGrantTypes("password", "client_credentials", "refresh_token", "authorization_code")//授权类型为密码、授权码、刷新token、客户端证书
                .scopes("all")//表示超级管理员，可获取所有访问信息
                .accessTokenValiditySeconds(7200)//单位：秒
                .refreshTokenValiditySeconds(7200);
    }

    //设置token类型
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.authenticationManager(authenticationManager()).allowedTokenEndpointRequestMethods(HttpMethod.GET, HttpMethod.POST);
        endpoints.userDetailsService(userDetailsService());
    }

    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        //允许表单认证
        security.allowFormAuthenticationForClients();
        //允许check_token访问
        security.checkTokenAccess("permitAll()");
    }

    @Bean
    AuthenticationManager authenticationManager() {
        AuthenticationManager authenticationManager = new AuthenticationManager() {

            @Override
            public Authentication authenticate(Authentication authentication) throws AuthenticationException {
                return daoAuthenticationProvider().authenticate(authentication);
            }
        };
        return authenticationManager;
    }

    @Bean
    public AuthenticationProvider daoAuthenticationProvider() {
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(userDetailsService());
        daoAuthenticationProvider.setHideUserNotFoundExceptions(false);
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        return daoAuthenticationProvider;
    }

    /**
     * 设置添加用户信息  正常应该从数据库读取
     *
     * @return
     */
    @Bean
    UserDetailsService userDetailsService() {
        InMemoryUserDetailsManager userDetailsManager = new InMemoryUserDetailsManager();
        userDetailsManager.createUser(User.withUsername("user_1").password(passwordEncoder().encode("110")).authorities("ROLE_USER").build());
        userDetailsManager.createUser(User.withUsername("user_2").password(passwordEncoder().encode("110")).authorities("ROLE_USER").build());
        return userDetailsManager;
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        //加密方式
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return bCryptPasswordEncoder;
    }
}
