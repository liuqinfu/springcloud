package com.study.springbootmycat.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**  初始化数据源信息
 * @author： leon
 * @date： 2020/11/30 01:10
 * @description： TODO
 * @modifiedBy：
 * @version: 1.0
 */
@Configuration
public class DataSourceConfig {

    @Bean(name = "selectDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.select")
    public DataSource selectDataSource(){
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "updateDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.update")
    public DataSource updateDataSource(){
        return DataSourceBuilder.create().build();
    }
}
