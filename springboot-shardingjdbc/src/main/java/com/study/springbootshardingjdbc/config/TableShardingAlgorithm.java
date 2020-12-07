package com.study.springbootshardingjdbc.config;

import com.dangdang.ddframe.rdb.sharding.api.ShardingValue;
import com.dangdang.ddframe.rdb.sharding.api.strategy.table.SingleKeyTableShardingAlgorithm;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author： leon
 * @date： 2020/11/30 18:31
 * @description： TODO
 * @modifiedBy：
 * @version: 1.0
 */
public class TableShardingAlgorithm implements SingleKeyTableShardingAlgorithm<Long> {

    /**
     * sql中关键字 匹配符包含=时，表的路由函数
     * @param collection  分表的小表集合
     * @param shardingValue  用于分片字段的值  userid
     * @return
     */
    @Override
    public String doEqualSharding(Collection<String> collection, ShardingValue<Long> shardingValue) {
        List<String> tableNameList = collection.stream().filter(tableName -> tableName.endsWith(shardingValue.getValue() * 2 + "")).collect(Collectors.toList());
        if (tableNameList.size() >0)return tableNameList.get(0);
        else throw new IllegalArgumentException();
    }

    @Override
    public Collection<String> doInSharding(Collection<String> collection, ShardingValue<Long> shardingValue) {
        return null;
    }

    @Override
    public Collection<String> doBetweenSharding(Collection<String> collection, ShardingValue<Long> shardingValue) {
        return null;
    }
}
