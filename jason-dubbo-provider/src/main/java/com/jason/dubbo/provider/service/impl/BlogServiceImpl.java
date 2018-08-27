package com.jason.dubbo.provider.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.jason.dubbo.provider.api.entity.Blog;
import com.jason.dubbo.provider.api.service.BlogService;
import com.jason.dubbo.provider.mapper.BlogMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @auther: xieyong
 * @date: 2018/8/27 11:59e
 * @Description:
 */
@Service(version = "1.0")
@Slf4j
public class BlogServiceImpl implements BlogService {
    @Autowired
    private BlogMapper blogMapper;

    @Override
    public List<Blog> queryBlog() {
        log.info("服务提供者被请求");
        return blogMapper.blogList();
    }
}
