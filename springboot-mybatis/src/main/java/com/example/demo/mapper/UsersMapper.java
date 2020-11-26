package com.example.demo.mapper;

import com.example.demo.enitiy.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 路径：com.example.demo.mapper
 * 类名：
 * 功能：《用一句描述一下》
 * 备注：
 * 创建人：typ
 * 创建时间：2019/1/28 15:15
 * 修改人：
 * 修改备注：
 * 修改时间：
 */
@Mapper
public interface UsersMapper {

    List<User> list();

    User qryById(String id);

    void insertByBatch(List<User> list);

    void updateByBatch(List<User> list);
}
