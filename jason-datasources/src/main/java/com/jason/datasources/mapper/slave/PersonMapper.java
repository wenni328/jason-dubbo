package com.jason.datasources.mapper.slave;

import com.jason.datasources.entity.slave.Person;

/**
 * @author: xieyong
 * @date: 2018/8/31 10:44
 * @Description:
 */
public interface PersonMapper {

    Person getById(Integer id);
}
