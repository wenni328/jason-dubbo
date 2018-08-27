package com.jason.dubbo.provider.mapper;


import com.jason.dubbo.provider.api.entity.Blog;

import java.util.List;

/**
 * @author: xieyong
 * @date: 2018/8/27 11:55
 * @Description:
 */
public interface BlogMapper {

    /**
     * 查询全部Blog
     *
     * @return
     */
    List<Blog> blogList();
}
