package com.example.demo.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * 路径：com.example.demo.entity
 * 类名：
 * 功能：《用一句话描述一下》
 * 备注：
 * 创建人：tanyinping
 * 创建时间：2018/7/15 22:15
 * 修改人：
 * 修改备注：
 * 修改时间：
 */
@Data
public class RedisModel implements Serializable {

    private String key;
    private Long value;
    private String name;
    private String password;
    private String tel;
    private String address;

}
