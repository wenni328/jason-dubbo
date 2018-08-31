package com.jason.datasources.entity.slave;

import lombok.Data;

import java.io.Serializable;

/**
 * @author: xieyong
 * @date: 2018/8/31 10:42
 * @Description:
 */
@Data
public class Person implements Serializable {

    private Integer id;

    private String username;
}
