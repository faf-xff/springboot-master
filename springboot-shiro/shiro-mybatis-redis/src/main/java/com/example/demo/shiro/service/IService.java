package com.example.demo.shiro.service;

import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 路径：com.example.demo.shiro.service
 * 类名：
 * 功能：通用接口
 * 备注：
 * 创建人：typ
 * 创建时间：2018/10/9 10:43
 * 修改人：
 * 修改备注：
 * 修改时间：
 */
@Service
public interface IService<T> {

    T selectByKey(Object key);

    int save(T entity);

    int delete(Object key);

    int updateAll(T entity);

    int updateNotNull(T entity);

    List<T> selectByExample(Object example);
}
