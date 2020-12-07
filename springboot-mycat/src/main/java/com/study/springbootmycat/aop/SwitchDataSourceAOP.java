package com.study.springbootmycat.aop;

import com.study.springbootmycat.config.DataSourceContextHandler;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author： leon
 * @date： 2020/11/30 01:24
 * @description： TODO
 * @modifiedBy：
 * @version: 1.0
 */
@Aspect
@Component
@Lazy(false)
@Order(0) //Order设定aop执行顺序，使之在数据库事务上先执行
public class SwitchDataSourceAOP {

    @Before("execution(* com.study.springbootmycat.service.*.*(..))")
    public void process(JoinPoint joinPoint){
        String methdName = joinPoint.getSignature().getName();
        if (methdName.startsWith("get")
                || methdName.startsWith("find")
                || methdName.startsWith("query")
                || methdName.startsWith("count")
                || methdName.startsWith("list")
                || methdName.startsWith("select")
                || methdName.startsWith("check")){
            DataSourceContextHandler.setDbType("selectDataSource");
        }else {
            DataSourceContextHandler.setDbType("updateDataSource");
        }
    }
}
