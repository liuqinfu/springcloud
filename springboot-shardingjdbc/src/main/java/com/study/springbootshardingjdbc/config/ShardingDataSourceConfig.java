package com.study.springbootshardingjdbc.config;

import com.dangdang.ddframe.rdb.sharding.id.generator.IdGenerator;
import com.dangdang.ddframe.rdb.sharding.id.generator.self.CommonSelfIdGenerator;
import com.google.common.collect.Maps;
import io.shardingjdbc.core.api.MasterSlaveDataSourceFactory;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.HashMap;

/**
 * @author： leon
 * @date： 2020/11/30 15:20
 * @description： TODO
 * @modifiedBy：
 * @version: 1.0
 */
@Configuration
@EnableConfigurationProperties(ShardingMasterSlaveConfig.class)
@Log4j2
//配置ds_master主数据员和读写分离配置
@ConditionalOnProperty({"sharding.jdbc.data-sources.ds_master.jdbc-url","sharding.jdbc.master-slave-rule.master-data-source-name"})
public class ShardingDataSourceConfig {

    @Autowired
    private ShardingMasterSlaveConfig shardingMasterSlaveConfig;

    /**
     * 配置数据源
     * @return
     * @throws SQLException
     */
    @Bean
    public DataSource masterSlaveDataSources() throws SQLException {
        final HashMap<String, DataSource> datasourceMap = Maps.newHashMap();
        datasourceMap.putAll(shardingMasterSlaveConfig.getDataSources());
        final HashMap<String, Object> newHashMap = Maps.newHashMap();

        //创建master slave数据源 读写分离
        DataSource dataSource = MasterSlaveDataSourceFactory.createDataSource(datasourceMap, shardingMasterSlaveConfig.getMasterSlaveRule(), newHashMap);
        //分表
        /*DataSourceRule dataSourceRule = new DataSourceRule(datasourceMap,"ds_master");
        //分表映射  将两个小表映射到t_order逻辑表
        TableRule orderTableRule = TableRule.builder("t_order").actualTables(Arrays.asList("t_order_0", "t_order_1")).dataSourceRule(dataSourceRule).build();
        ShardingRule shardingRule = ShardingRule.builder().dataSourceRule(dataSourceRule).tableRules(Arrays.asList(orderTableRule))
                //根据user_id字段进行分表
                .tableShardingStrategy(new TableShardingStrategy("user_id", new TableShardingAlgorithm())).build();
        DataSource dataSource = ShardingDataSourceFactory.createDataSource(shardingRule);*/
        return dataSource;
    }

    /**
     * 配置主键自动增长策略
     * @return
     */
    @Bean
    public IdGenerator getIdGenerator(){
        return new CommonSelfIdGenerator();
    }


}
