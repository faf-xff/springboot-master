package com.example.demo.dao;

import com.example.demo.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * 路径：com.example.demo.dao
 * 类名：
 * 功能：《用一句描述一下》
 * 备注：
 * 创建人：typ
 * 创建时间：2018/9/4 16:22
 * 修改人：
 * 修改备注：
 * 修改时间：
 */
@Mapper
public interface UserMapper {

    /**
     * 方法名：login
     * 功能：登录
     * 描述：
     * 创建人：typ
     * 创建时间：2018/9/4 16:25
     * 修改人：
     * 修改描述：
     * 修改时间：
     */
    public User getByName(String name);

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
    public Integer reg(User user);
}
