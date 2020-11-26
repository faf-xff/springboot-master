package com.example.demo.service;

import com.example.demo.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * 路径：com.example.demo.service
 * 类名：
 * 功能：《用一句描述一下》
 * 备注：
 * 创建人：typ
 * 创建时间：2019/1/21 12:07
 * 修改人：
 * 修改备注：
 * 修改时间：
 */
public interface UserService {

    List<User> findAllByName(String name);

    Page<User> findAll(Pageable pageable);

    User findByParam(String username, String password);

    List<User> findByConditionAndOrder(String username, String password);

    void del(Integer id);

    void save(User user);

    void saveAll(List<User> users);
}
