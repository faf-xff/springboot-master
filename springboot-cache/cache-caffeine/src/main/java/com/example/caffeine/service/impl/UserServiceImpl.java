package com.example.caffeine.service.impl;

import com.example.caffeine.entity.User;
import com.example.caffeine.service.UserService;
import com.github.benmanes.caffeine.cache.Cache;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @path：com.example.caffeine.service.impl.UserServiceImpl.java
 * @className：UserServiceImpl.java
 * @description：测试service（硬编码方式）
 * @author：tanyp
 * @dateTime：2020/3/24 20:55
 * @editNote：
 */
@Slf4j
@Service
public class UserServiceImpl implements UserService {

    // 模拟数据库，存储数据
    private Map<String, Object> userMap = new HashMap<>();

    @Autowired
    Cache<String, Object> cache;

    /**
     * @methodName：addUserInfo
     * @description：创建用户信息，并存入缓存
     * @author：tanyp
     * @dateTime：2020/3/24 20:56
     * @Params： [userInfo]
     * @Return： void
     * @editNote：
     */
    @Override
    public void addUserInfo(User userInfo) {
        log.info("创建用户信息，并存入缓存");
        // 入库
        userMap.put(userInfo.getId(), userInfo);
        // 加入缓存
        cache.put(userInfo.getId(), userInfo);
    }

    /**
     * @methodName：getById
     * @description：获取用户信息，并更新缓存
     * @author：tanyp
     * @dateTime：2020/3/24 20:56
     * @Params： [id]
     * @Return： com.example.caffeine.entity.User
     * @editNote：
     */
    @Override
    public User getById(String id) {
        log.info("获取用户信息，并更新缓存");
        // 从缓存读取
        cache.getIfPresent(id);
        User userInfo = (User) cache.asMap().get(id);
        if (userInfo != null) {
            return userInfo;
        }

        // 如果缓存中不存在，则从库中查找
        userInfo = (User) userMap.get(id);
        // 如果用户信息不为空，则加入缓存
        if (userInfo != null) {
            cache.put(String.valueOf(userInfo.getId()), userInfo);
        }
        return userInfo;
    }

    /**
     * @methodName：updateUserInfo
     * @description：修改用户信息，并更新缓存数据
     * @author：tanyp
     * @dateTime：2020/3/24 20:56
     * @Params： [userInfo]
     * @Return： com.example.caffeine.entity.User
     * @editNote：
     */
    @Override
    public User updateUserInfo(User userInfo) {
        log.info("修改用户信息，并更新缓存数据");
        if (!userMap.containsKey(userInfo.getId())) {
            return null;
        }
        // 取旧的值
        User oldUserInfo = (User) userMap.get(userInfo.getId());
        // 替换内容
        if (!StringUtils.isEmpty(oldUserInfo.getAge())) {
            oldUserInfo.setAge(userInfo.getAge());
        }
        if (!StringUtils.isEmpty(oldUserInfo.getName())) {
            oldUserInfo.setName(userInfo.getName());
        }
        if (!StringUtils.isEmpty(oldUserInfo.getSex())) {
            oldUserInfo.setSex(userInfo.getSex());
        }
        // 将新的对象存储，更新旧对象信息
        userMap.put(oldUserInfo.getId(), oldUserInfo);
        // 替换缓存中的值
        cache.put(String.valueOf(oldUserInfo.getId()), oldUserInfo);
        return oldUserInfo;
    }

    /**
     * @methodName：deleteById
     * @description：删除用户信息，并清除缓存
     * @author：tanyp
     * @dateTime：2020/3/24 20:56
     * @Params： [id]
     * @Return： void
     * @editNote：
     */
    @Override
    public void deleteById(String id) {
        log.info("删除用户信息，并清除缓存");
        userMap.remove(id);
        // 从缓存中删除
        cache.asMap().remove(String.valueOf(id));
    }
}
