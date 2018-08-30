package com.jason.webflux.controller;

import com.jason.webflux.entity.User;
import com.jason.webflux.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

/**
 * @author: xieyong
 * @date: 2018/8/30 15:40
 * @Description:
 */
@RestController
@RequestMapping("/controller")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @RequestMapping("/save")
    public Mono<User> save(@RequestBody User user){
        return userRepository.save(user);
    }

    @RequestMapping("/{username}")
    public Mono<User> save(@PathVariable(value = "username") String username){
        return userRepository.findByUsername(username);
    }
}
