package com.study.springbootsecurity.config;

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;

/**
 * 自定义错误页面
 * @author： leon
 * @date： 2020/11/20 23:26
 * @description： TODO
 * @modifiedBy：
 * @version: 1.0
 */
@Configuration
public class WebServerAutoConfiguration {

    @Bean
    public ConfigurableServletWebServerFactory webServerFactory(){
        TomcatServletWebServerFactory serverFactory = new TomcatServletWebServerFactory();
        ErrorPage bad_request = new ErrorPage(HttpStatus.BAD_REQUEST, "/error/400");
        ErrorPage noPromiss_request = new ErrorPage(HttpStatus.UNAUTHORIZED, "/error/401");
        ErrorPage forbidden_request = new ErrorPage(HttpStatus.FORBIDDEN, "/error/403");
        ErrorPage notFound_request = new ErrorPage(HttpStatus.NOT_FOUND, "/error/404");
        ErrorPage unsupported_request = new ErrorPage(HttpStatus.UNSUPPORTED_MEDIA_TYPE, "/error/415");
        ErrorPage serverError_request = new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/error/500");
        serverFactory.addErrorPages(bad_request,noPromiss_request,forbidden_request,notFound_request,unsupported_request,serverError_request);
        return serverFactory;
    }

}
