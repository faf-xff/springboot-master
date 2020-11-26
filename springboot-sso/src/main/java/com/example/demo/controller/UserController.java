package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import com.example.demo.utils.MD5Util;
import com.example.demo.utils.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 路径：com.example.demo.controller
 * 类名：
 * 功能：《用一句描述一下》
 * 备注：
 * 创建人：typ
 * 创建时间：2018/9/4 16:22
 * 修改人：
 * 修改备注：
 * 修改时间：
 */
@Slf4j
@RestController
@RequestMapping("/")
public class UserController {

    @Autowired
    private UserService userService;


    /**
     * 方法名：login
     * 功能：登录
     * 描述：
     * 创建人：typ
     * 创建时间：2018/9/5 10:05
     * 修改人：
     * 修改描述：
     * 修改时间：
     */
    @GetMapping("/login")
    @ResponseBody
    public Result login(String name, String password, HttpServletRequest request, HttpServletResponse response){
        return userService.login(name,password,request,response);
    }

    /**
     * 方法名：
     * 功能：获取token
     * 描述：
     * 创建人：typ
     * 创建时间：2018/9/5 12:08
     * 修改人：
     * 修改描述：
     * 修改时间：
     */
    @GetMapping("/getToken")
    @ResponseBody
    public Result getToken(String token){
        return userService.getToken(token);
    }

    /**
     * 方法名：reg
     * 功能：注册
     * 描述：
     * 创建人：typ
     * 创建时间：2018/9/5 14:18
     * 修改人：
     * 修改描述：
     * 修改时间：
     */
    @PostMapping("/reg")
    public Result reg(@RequestBody User user){
        return userService.reg(user);
    }

    /**
     * 方法名：
     * 功能：退出
     * 描述：
     * 创建人：typ
     * 创建时间：2018/9/5 12:10
     * 修改人：
     * 修改描述：
     * 修改时间：
     */
    @GetMapping("/logout")
    public Result logout(String token, HttpServletRequest request, HttpServletResponse response){
        return userService.logout(token,request,response);
    }
}
