package com.jason.jwt.config.exception;

/**
 * @author: xieyong
 * @date: 2018/9/3 11:51
 * @Description:
 */
public class UnauthorizedException extends RuntimeException {

    public UnauthorizedException(String msg) {
        super(msg);
    }

    public UnauthorizedException() {
        super();
    }
}
