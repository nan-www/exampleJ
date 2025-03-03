package com.pratice.example.nBatis.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * (Foo)实体类
 *
 * @author makejava
 * @since 2025-02-24 01:52:56
 */
@Data
public class Foo implements Serializable {
    private Long id;

    private String name;

    private Integer age;


}

