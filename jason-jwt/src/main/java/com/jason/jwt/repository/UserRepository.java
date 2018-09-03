package com.jason.jwt.repository;

import com.jason.jwt.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author: xieyong
 * @date: 2018/9/3 10:05
 * @Description:
 */
@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

    User getByUsername(String username);
}
