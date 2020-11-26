package com.example.demo.service.impl;

import com.example.demo.dao.UserRepository;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 路径：com.example.demo.service.impl
 * 类名：
 * 功能：《用一句描述一下》
 * 备注：
 * 创建人：typ
 * 创建时间：2019/1/21 12:07
 * 修改人：
 * 修改备注：
 * 修改时间：
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> findAllByName(String name) {
        return userRepository.findAllByusername(name);
    }

    @Override
    public Page<User> findAll(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    @Override
    public User findByParam(String username, String password) {
        return userRepository.findByParam(username,password);
    }

    @Override
    public List<User> findByConditionAndOrder(String username, String password) {
        return userRepository.findByConditionAndOrder(username,password);
    }

    @Override
    public void del(Integer id) {
        userRepository.deleteById(id);
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public void saveAll(List<User> users) {
        userRepository.saveAll(users);
    }
}
