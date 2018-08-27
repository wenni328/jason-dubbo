package com.jason.dubbo.consumer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.jason.dubbo.provider.api.entity.Blog;
import com.jason.dubbo.provider.api.service.BlogService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author: xieyong
 * @date: 2018/8/27 12:05
 * @Description:
 */
@RestController
@RequestMapping("/consumer")
public class ConsumerController {


    @Reference(version = "1.0",check = true)
    private BlogService blogService;

    @RequestMapping("/query")
    public List<Blog> query() {
        return blogService.queryBlog();
    }
}
