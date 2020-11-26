package com.example.demo.shiro.service;

import com.example.demo.shiro.entity.User;
import com.github.pagehelper.PageInfo;

/**
 * 路径：com.example.demo.shiro.service
 * 类名：
 * 功能：《用一句描述一下》
 * 备注：
 * 创建人：typ
 * 创建时间：2018/10/9 10:45
 * 修改人：
 * 修改备注：
 * 修改时间：
 */
public interface UserService extends IService<User>{
    PageInfo<User> selectByPage(User user, int start, int length);

    User selectByUsername(String username);

    void delUser(Integer userid);

}
