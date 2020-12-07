package com.study.springbootes.document;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

/**
 * @author： leon
 * @date： 2020/11/23 15:42
 * @description： TODO
 * @modifiedBy：
 * @version: 1.0
 */
@Data
@Document(indexName = "myindex",type = "user")
public class User {

    @Id
    private String id;

    @Field(name = "name",type = FieldType.Text)
    private String name;

    @Field(name = "age",type = FieldType.Integer)
    private int age;

    @Field(name = "sex",type = FieldType.Integer)
    private int sex;

    @Field(name = "car",type = FieldType.Text)
    private String car;
}
