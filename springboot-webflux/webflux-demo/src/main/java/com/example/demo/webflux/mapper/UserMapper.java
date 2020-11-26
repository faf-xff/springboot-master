package com.example.demo.webflux.mapper;

import com.example.demo.webflux.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * 路径：com.example.demo.webflux.mapper.UserMapper.java
 * 类名：UserMapper.java
 * 功能：《用一句描述一下》
 * 备注：
 * 创建人：typ
 * 创建时间：2019/6/2 19:35
 * 修改人：
 * 修改备注：
 * 修改时间：
 */
@Mapper
public interface UserMapper {

    List<User> qryAll();

    User qryById(@Param("id") String id);

    Integer save(User user);

    Integer update(User user);

    Integer del(@Param("id") String id);
}
