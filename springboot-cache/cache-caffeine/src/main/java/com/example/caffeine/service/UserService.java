package com.example.caffeine.service;

import com.example.caffeine.entity.User;

/**
 * @path：com.example.caffeine.service.UserService.java
 * @className：UserService.java
 * @description：测试service
 * @author：tanyp
 * @dateTime：2020/3/24 20:53
 * @editNote：
 */
public interface UserService {

    void addUserInfo(User userInfo);

    User getById(String id);

    User updateUserInfo(User userInfo);

    void deleteById(String id);
}
