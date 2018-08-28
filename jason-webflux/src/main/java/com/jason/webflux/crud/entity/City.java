package com.jason.webflux.crud.entity;

import lombok.Data;

/**
 * @auther: xieyong
 * @date: 2018/8/28 10:28
 * @Description:
 */
@Data
public class City {
    /**
     * 城市编号
     */
    private Long id;

    /**
     * 省份编号
     */
    private Long provinceId;

    /**
     * 城市名称
     */
    private String cityName;

    /**
     * 描述
     */
    private String description;

}
