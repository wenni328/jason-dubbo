package com.jason.webflux.mongodb.service;

import com.jason.webflux.mongodb.entity.User;
import com.jason.webflux.mongodb.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author: xieyong
 * @date: 2018/8/28 20:17
 * @Description:
 */
@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public Mono<User> save(User user) {
        return userRepository.save(user)
                .onErrorResume(e -> userRepository.findByUsername(user.getUsername()))
                .flatMap(originUser -> {
                    user.setId(originUser.getId());
                    return userRepository.save(user);
                });
    }

    public Mono<Long> deleteByUsername(String username) {
        return userRepository.deleteByUsername(username);
    }

    public Mono<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public Flux<User> findAll() {
        return userRepository.findAll();
    }
}
