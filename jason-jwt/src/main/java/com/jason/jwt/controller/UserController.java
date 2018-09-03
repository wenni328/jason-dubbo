package com.jason.jwt.controller;

import com.jason.jwt.entity.User;
import com.jason.jwt.repository.UserRepository;
import com.jason.jwt.utils.JWTUtil;
import com.jason.jwt.utils.JasonResult;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.UnauthorizedException;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

/**
 * @author: xieyong
 * @date: 2018/9/3 10:42
 * @Description:
 */
@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/login")
    public JasonResult getByUsername(@RequestBody User user) {
        User userSql = userRepository.getByUsername(user.getUsername());
        if (userSql.getPassword().equals(user.getPassword())) {
            return JasonResult.ok("Login success", JWTUtil.sign(userSql.getUsername(), userSql.getPassword()));
        } else {
            throw new UnauthorizedException();
        }
    }

    /**
     * headers携带Authorization信息token
     * @return
     */
    @GetMapping("/require_auth")
    @RequiresAuthentication
    public JasonResult requireAuth() {
        return JasonResult.ok("You are authenticated", null);
    }

    @RequestMapping(path = "/401")
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public JasonResult unauthorized() {
        return JasonResult.error("Unauthorized");
    }

    @GetMapping("/article")
    public JasonResult article() {
        Subject subject = SecurityUtils.getSubject();
        if (subject.isAuthenticated()) {
            return JasonResult.ok( "You are already logged in", null);
        } else {
            return JasonResult.ok( "You are guest", null);
        }
    }

}
