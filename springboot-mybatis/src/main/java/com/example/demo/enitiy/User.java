package com.example.demo.enitiy;

import lombok.Data;

import javax.persistence.Table;

/**
 * 路径：com.example.demo.enitiy
 * 类名：
 * 功能：《用一句描述一下》
 * 备注：
 * 创建人：typ
 * 创建时间：2019/1/28 15:14
 * 修改人：
 * 修改备注：
 * 修改时间：
 */
@Data
public class User {

    private String id;

    private String username;

    private String password;

    public User(String id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }
}
