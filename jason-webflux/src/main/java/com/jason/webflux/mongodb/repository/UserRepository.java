package com.jason.webflux.mongodb.repository;

import com.jason.webflux.mongodb.entity.User;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;

/**
 * @author: xieyong
 * @date: 2018/8/28 20:13
 * @Description:
 */
public interface UserRepository extends ReactiveCrudRepository<User, String> {

    Mono<User> findByUsername(String username);


    Mono<Long> deleteByUsername(String s);
}
