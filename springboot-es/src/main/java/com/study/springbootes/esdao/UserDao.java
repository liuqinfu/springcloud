package com.study.springbootes.esdao;

import com.study.springbootes.document.User;
import org.springframework.data.repository.CrudRepository;

/**
 * @author： leon
 * @date： 2020/11/23 15:50
 * @description： TODO
 * @modifiedBy：
 * @version: 1.0
 */
// CrudRepository<User,String>  文档类型，文档主键类型
public interface UserDao extends CrudRepository<User,String> {
}
