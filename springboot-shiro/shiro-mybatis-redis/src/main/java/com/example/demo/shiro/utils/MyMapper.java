package com.example.demo.shiro.utils;

import tk.mybatis.mapper.common.ConditionMapper;
import tk.mybatis.mapper.common.IdsMapper;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * 路径：com.example.demo.shiro.utils
 * 类名：
 * 功能：《用一句描述一下》
 * 备注：特别注意，该接口不能被扫描到，否则会出错
 * 创建人：typ
 * 创建时间：2018/10/9 9:43
 * 修改人：
 * 修改备注：
 * 修改时间：
 */
public interface MyMapper<T> extends Mapper<T>, MySqlMapper<T>, IdsMapper<T>, ConditionMapper<T> {}

