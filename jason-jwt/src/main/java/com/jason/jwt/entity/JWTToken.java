package com.jason.jwt.entity;

import org.apache.shiro.authc.AuthenticationToken;

/**
 * @author: xieyong
 * @date: 2018/9/3 11:33
 * @Description:
 */
public class JWTToken implements AuthenticationToken {
    // 密钥
    private String token;

    public JWTToken(String token) {
        this.token = token;
    }

    @Override
    public Object getPrincipal() {
        return token;
    }

    @Override
    public Object getCredentials() {
        return token;
    }
}
