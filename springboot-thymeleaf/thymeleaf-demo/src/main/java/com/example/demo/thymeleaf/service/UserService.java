package com.example.demo.thymeleaf.service;

import com.example.demo.thymeleaf.entity.User;

import java.util.List;
import java.util.Map;

/**
 * 路径：com.example.demo.thymeleaf.service
 * 类名：
 * 功能：《用一句描述一下》
 * 备注：
 * 创建人：typ
 * 创建时间：2019/3/14 15:00
 * 修改人：
 * 修改备注：
 * 修改时间：
 */
public interface UserService {

    User getUser(String id);

    List<User> list();
}
