package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.utils.Result;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 路径：com.example.demo.service
 * 类名：
 * 功能：《用一句描述一下》
 * 备注：
 * 创建人：typ
 * 创建时间：2018/9/4 16:23
 * 修改人：
 * 修改备注：
 * 修改时间：
 */
public interface UserService {

    /**
     * 方法名：login
     * 功能：登录
     * 描述：
     * 创建人：typ
     * 创建时间：2018/9/4 16:28
     * 修改人：
     * 修改描述：
     * 修改时间：
     */
    public Result login(String name, String password, HttpServletRequest request, HttpServletResponse response);

    /**
     * 方法名：getToken
     * 功能：获取用户token
     * 描述：
     * 创建人：typ
     * 创建时间：2018/9/5 11:58
     * 修改人：
     * 修改描述：
     * 修改时间：
     */
    public Result getToken(String token);

    /**
     * 方法名：logout
     * 功能：退出
     * 描述：
     * 创建人：typ
     * 创建时间：2018/9/5 12:12
     * 修改人：
     * 修改描述：
     * 修改时间：
     */
    public Result logout(String tokne, HttpServletRequest request, HttpServletResponse response);

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
    public Result reg(User user);
}
