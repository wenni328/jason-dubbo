package com.jason.datasources.entity.master;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @author: xieyong
 * @date: 2018/8/31 10:37
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
