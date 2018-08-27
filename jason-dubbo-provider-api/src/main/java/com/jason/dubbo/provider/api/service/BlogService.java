package com.jason.dubbo.provider.api.service;

import com.jason.dubbo.provider.api.entity.Blog;

import java.util.List;

/**
 * @auther: xieyong
 * @date: 2018/8/27 13:39
 * @Description:
 */
public interface BlogService {
    /**
     * 查询全部的博客列表
     *
     * @return
     */
    List<Blog> queryBlog();
}
