package com.jason.jwt.config;

import com.jason.jwt.config.exception.UnauthorizedException;
import com.jason.jwt.utils.JasonResult;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.ShiroException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * @author: xieyong
 * @date: 2018/9/3 10:22
 * @Description:
 */
@RestControllerAdvice
@Slf4j
public class ExceptionController {

    // 捕捉shiro的异常
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(ShiroException.class)
    public JasonResult handle401(ShiroException e) {
        return JasonResult.error("shiro的异常");
    }

    // 捕捉UnauthorizedException
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(UnauthorizedException.class)
    public JasonResult handle401() {
        log.info("xxxxxxxxxx:UnauthorizedException");
        return JasonResult.error("UnauthorizedException");
    }

    // 捕捉其他所有异常
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public JasonResult globalException(HttpServletRequest request, Throwable ex) {
        return JasonResult.error("其他异常");
    }

    private HttpStatus getStatus(HttpServletRequest request) {
        Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
        if (statusCode == null) {
            return HttpStatus.INTERNAL_SERVER_ERROR;
        }
        return HttpStatus.valueOf(statusCode);
    }
}
