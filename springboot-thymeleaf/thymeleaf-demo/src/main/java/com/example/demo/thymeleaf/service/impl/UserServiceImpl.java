package com.example.demo.thymeleaf.service.impl;

import com.example.demo.thymeleaf.entity.User;
import com.example.demo.thymeleaf.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 路径：com.example.demo.thymeleaf.service.impl
 * 类名：
 * 功能：《用一句描述一下》
 * 备注：
 * 创建人：typ
 * 创建时间：2019/3/14 15:01
 * 修改人：
 * 修改备注：
 * 修改时间：
 */
@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Override
    public User getUser(String id) {
        User user = new User();
        user.setId("10001");
        user.setName("李四");
        user.setPassword("123456");
        user.setSex("男");
        user.setTel("12345678901");
        user.setEmail("lisi@123.com");
        return user;
    }

    @Override
    public List<User> list() {
        List<User> list = new ArrayList<>();
        User user = new User();
        user.setId("10001");
        user.setName("王五");
        user.setPassword("123456");
        user.setSex("男");
        user.setTel("12345678901");
        user.setEmail("wangwu@123.com");

        User user1 = new User();
        user1.setId("10002");
        user1.setName("李四");
        user1.setPassword("123456");
        user1.setSex("男");
        user1.setTel("12345678901");
        user1.setEmail("lisi@123.com");

        User user2 = new User();
        user2.setId("10003");
        user2.setName("赵六");
        user2.setPassword("123456");
        user2.setSex("男");
        user2.setTel("12345678901");
        user2.setEmail("zhaoliu@123.com");
        list.add(user);
        list.add(user1);
        list.add(user2);
        return list;
    }
}
