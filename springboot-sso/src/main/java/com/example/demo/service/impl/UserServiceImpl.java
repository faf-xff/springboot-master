package com.example.demo.service.impl;

import com.alibaba.fastjson.JSON;
import com.example.demo.dao.UserMapper;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import com.example.demo.utils.CookieUtils;
import com.example.demo.utils.MD5Util;
import com.example.demo.utils.Result;
import com.example.demo.utils.ResultUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

/**
 * 路径：com.example.demo.service.impl
 * 类名：
 * 功能：《用一句描述一下》
 * 备注：
 * 创建人：typ
 * 创建时间：2018/9/4 16:24
 * 修改人：
 * 修改备注：
 * 修改时间：
 */
@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private JedisPool jedisPool;

    @Autowired
    private UserMapper userMapper;


    /**
     * 方法名：login
     * 功能：
     * 描述：
     * 创建人：typ
     * 创建时间：2018/9/4 16:28
     * 修改人：
     * 修改描述：
     * 修改时间：
     */
    @Override
    public Result login(String name, String password, HttpServletRequest request, HttpServletResponse response) {
        log.info("login start 入参：name:{},password:{}",name,password);
        User user = userMapper.getByName(name);
        if(user !=null){
            String pass = MD5Util.getMD5(password);
            if(pass.equals(user.getPassword())){
                String key = String.valueOf(UUID.randomUUID());
                String vlaue = String.valueOf(JSON.toJSON(user));
                Jedis jedis = jedisPool.getResource();
                jedis.set(key,vlaue);
                jedis.expire(key,60*60*24*7);
                CookieUtils.setCookie(request,response,"TOKEN",key,60*60*24*7);
                log.info("login end 出参：{}",vlaue);
                return ResultUtils.error(1,"登录成功！");
            }else{
                log.info("login end 出参：用户名或密码错误");
                return ResultUtils.error(0,"用户名或密码错误！");
            }
        }else{
            log.info("login end 出参：用户不存在");
            return ResultUtils.error(0,"用户不存在！");
        }
    }

    /**
     * 方法名：
     * 功能：获取用户token
     * 描述：
     * 创建人：typ
     * 创建时间：2018/9/5 11:59
     * 修改人：
     * 修改描述：
     * 修改时间：
     */
    @Override
    public Result getToken(String token) {
        log.info("getToken start 入参：{}",token);
        Jedis jedis = jedisPool.getResource();
        String userStr = jedis.get(token);
        if(userStr != null && !"".equals(userStr)){
            User user = JSON.parseObject(userStr,User.class);
            user.setPassword("");
            log.info("getToken end 出参：{}",user);
            return ResultUtils.success(1,"请求成功！",user);
        }
        return ResultUtils.error(0,"请求失败！");
    }

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
    @Override
    public Result logout(String token, HttpServletRequest request, HttpServletResponse response) {
        log.info("logout start 入参：{}",token);
        Jedis jedis = jedisPool.getResource();
        try {
            jedis.del(token);
            CookieUtils.deleteCookie(request,response,"TOKEN");
            log.info("logout end 入参：{}");
            return ResultUtils.success(1,"请求成功！",null);
        }catch (Exception e){
            e.printStackTrace();
        }
        return ResultUtils.error(0,"请求失败！");
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
    public Result reg(User user){
        log.info("reg start 入参：{}",JSON.toJSON(user));
        User u = userMapper.getByName(user.getUserName());
        if(u == null){
            String pass = MD5Util.getMD5(user.getPassword());
            user.setPassword(pass);
            Integer rows = userMapper.reg(user);
            if(rows > 0){
                log.info("reg end 出参：rows:{}",rows);
                return ResultUtils.success(1,"注册成功!",null);
            }else{
                log.info("reg end 出参：注册失败");
                return ResultUtils.error(0,"注册失败！");
            }
        }else{
            log.info("reg end 出参：用户名已存在");
            return ResultUtils.error(0,"用户名已存在！");
        }
    }
}
