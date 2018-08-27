package com.jason.dubbo.provider;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author xieyong
 */
@SpringBootApplication
@MapperScan("com.jason.dubbo.provider.mapper")
@EnableDubbo
public class JasonDubboProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(JasonDubboProviderApplication.class, args);
    }

}
