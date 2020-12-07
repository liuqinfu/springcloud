package com.study.springbootmycat.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * @author： leon
 * @date： 2020/11/30 01:15
 * @description： TODO
 * @modifiedBy：
 * @version: 1.0
 */
@Component
@Primary
public class DynamicDataSource  extends AbstractRoutingDataSource {


    @Autowired
    @Qualifier("selectDataSource")
    private DataSource selectDataSource;

    @Autowired
    @Qualifier("updateDataSource")
    private DataSource updateDataSource;

    /**
     * 主要的方法，返回生效的数据源名称
     * @return
     */
    @Override
    protected Object determineCurrentLookupKey() {
        System.out.println("DataSourceContextHandler---------------"+DataSourceContextHandler.getDbType());
        return DataSourceContextHandler.getDbType();
    }

    /**
     * 配置数据源信息  将数据源注册进数据源路由器
     */
    @Override
    public void afterPropertiesSet() {
        Map dbs = new HashMap();
        dbs.put("selectDataSource",selectDataSource);
        dbs.put("updateDataSource",updateDataSource);
        setTargetDataSources(dbs);
        setDefaultTargetDataSource(updateDataSource);
        super.afterPropertiesSet();
    }
}
