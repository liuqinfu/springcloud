package com.study.springbootmycat.config;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/**
 * @author： leon
 * @date： 2020/11/30 01:07
 * @description： TODO
 * @modifiedBy：
 * @version: 1.0
 */
@Component
@Lazy(false)
public class DataSourceContextHandler {

    //保存本地多数据源
    private static final ThreadLocal<String> context = new ThreadLocal<>();

    public static void setDbType(String dbType){
        context.set(dbType);
    }

    public static String getDbType(){
        return context.get();
    }

    public static void removeDbType(){
        context.remove();
    }
}
