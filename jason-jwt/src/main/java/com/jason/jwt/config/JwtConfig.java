package com.jason.jwt.config;

import com.jason.jwt.filter.JwtFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: xieyong
 * @date: 2018/8/31 16:24
 * @Description:
 */
@Configuration
public class JwtConfig {

    @Bean
    public FilterRegistrationBean jwtFilter() {
        final FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        registrationBean.setFilter(new JwtFilter());
        registrationBean.addUrlPatterns("/secure/*");

        return registrationBean;
    }
}
