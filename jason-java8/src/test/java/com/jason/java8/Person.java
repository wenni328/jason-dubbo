package com.jason.java8;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author: xieyong
 * @date: 2018/8/31 14:57
 * @Description:
 */
@AllArgsConstructor
@Data
public class Person {

    private String name;

    private String sex;

    private Integer age;

    private Integer money;
}
