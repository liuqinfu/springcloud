package com.study.springbootshardingjdbc.config;

import com.zaxxer.hikari.HikariDataSource;
import io.shardingjdbc.core.api.config.MasterSlaveRuleConfiguration;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.HashMap;
import java.util.Map;

/**
 * @author： leon
 * @date： 2020/11/30 15:00
 * @description： TODO
 * @modifiedBy：
 * @version: 1.0
 */
@Data
@ConfigurationProperties(prefix = "sharding.jdbc")
public class ShardingMasterSlaveConfig {

    //存放本地多个数据源
    private Map<String, HikariDataSource> dataSources = new HashMap<>();

    private MasterSlaveRuleConfiguration masterSlaveRule;

}
