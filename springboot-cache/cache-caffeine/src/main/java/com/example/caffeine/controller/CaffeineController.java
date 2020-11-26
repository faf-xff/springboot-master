package com.example.caffeine.controller;

import com.example.caffeine.entity.User;
import com.example.caffeine.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @path：com.example.caffeine.controller.CaffeineController.java
 * @className：CaffeineController.java
 * @description： 集成Caffeine方式一:直接引入Caffeine依赖，然后使用Caffeine方法实现缓存
 * @author：tanyp
 * @dateTime：2020/3/24 20:50
 * @editNote：
 */
@Slf4j
@RestController
@RequestMapping("v1")
public class CaffeineController {

    @Autowired
    private UserService userService;

    /**
     * @methodName：getById
     * @description：获取用户信息
     * @author：tanyp
     * @dateTime：2020/3/24 21:15
     * @Params： [id]
     * @Return： java.lang.Object
     * @editNote：
     */
    @GetMapping("getById")
    public Object getById(String id) {
        User userInfo = userService.getById(id);
        if (userInfo == null) {
            return "没有该用户";
        }
        return userInfo;
    }

    /**
     * @methodName：addUserInfo
     * @description：添加用户信息
     * @author：tanyp
     * @dateTime：2020/3/24 21:15
     * @Params： [userInfo]
     * @Return： java.lang.Object
     * @editNote：
     */
    @PostMapping("addUserInfo")
    public Object addUserInfo(@RequestBody User userInfo) {
        userService.addUserInfo(userInfo);
        return "SUCCESS";
    }

    /**
     * @methodName：updateUserInfo
     * @description：修改用户信息
     * @author：tanyp
     * @dateTime：2020/3/24 21:16
     * @Params： [userInfo]
     * @Return： java.lang.Object
     * @editNote：
     */
    @PostMapping("updateUserInfo")
    public Object updateUserInfo(@RequestBody User userInfo) {
        User newUserInfo = userService.updateUserInfo(userInfo);
        if (newUserInfo == null) {
            return "不存在该用户";
        }
        return newUserInfo;
    }

    /**
     * @methodName：deleteById
     * @description：删除用户信息
     * @author：tanyp
     * @dateTime：2020/3/24 21:16
     * @Params： [id]
     * @Return： java.lang.Object
     * @editNote：
     */
    @GetMapping("deleteById")
    public Object deleteById(String id) {
        userService.deleteById(id);
        return "SUCCESS";
    }


}
