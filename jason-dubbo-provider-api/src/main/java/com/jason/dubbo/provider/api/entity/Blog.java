package com.jason.dubbo.provider.api.entity;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @auther: xieyong
 * @date: 2018/8/27 11:56
 * @Description:
 */
@Data
public class Blog implements Serializable {

    private Integer id;

    private String title;

    private String author;

    private Integer authorId;

    private String content;

    private String html;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    private String mark;

    private String sorts;

    private String picture;

}
