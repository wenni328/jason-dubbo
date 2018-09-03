package com.jason.jwt.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author: xieyong
 * @date: 2018/9/3 09:57
 * @Description:
 */
@Data
@Entity
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "name")
    private String username;

    private String password;

    private String salt;
}
