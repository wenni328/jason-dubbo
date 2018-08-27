package com.jason.dubbo.provider.service.impl;

import com.jason.dubbo.provider.api.entity.Blog;
import com.jason.dubbo.provider.api.service.BlogService;
import lombok.extern.slf4j.Slf4j;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


/**
 * @auther: xieyong
 * @date: 2018/8/27 17:37
 * @Description:
 */
@SpringBootTest
@RunWith(SpringRunner.class)
@Slf4j
public class BlogServiceImplTest {

    @Autowired
    private BlogService blogService;
    @Test
    public void queryBlog() {
        List<Blog> list=blogService.queryBlog();
        list.forEach(o->{
            log.info(o.getTitle());
        });
    }
}
