package com.study.apimember.entity;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * @author 我走路带风
 * @since 2020/11/3 16:05
 */
@Accessors(chain = true)
@Data
public class User {

    private String id;
    private String name;
    private int age;
    private String port;
}
