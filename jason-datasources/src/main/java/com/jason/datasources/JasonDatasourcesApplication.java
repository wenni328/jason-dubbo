package com.jason.datasources;

import com.jason.datasources.entity.master.Blog;
import com.jason.datasources.entity.slave.Person;
import com.jason.datasources.mapper.master.BlogMapper;
import com.jason.datasources.mapper.slave.PersonMapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@MapperScan("com.jason.datasources.mapper")
@RestController
@RequestMapping("/datasource")
public class JasonDatasourcesApplication {

    @Autowired
    private PersonMapper personMapper;
    @Autowired
    private BlogMapper blogMapper;

    public static void main(String[] args) {
        SpringApplication.run(JasonDatasourcesApplication.class, args);
    }

    @PostMapping("/person")
    public Person getById(@RequestParam(value = "id") Integer id) {
        return personMapper.getById(id);
    }

    @PostMapping("/blog")
    public Blog getByBlogId(@RequestParam(value = "id") Integer id) {
        return blogMapper.getById(id);
    }
}
