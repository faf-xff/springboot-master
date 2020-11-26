package com.example.demo.mapper;

import com.example.demo.entity.Config;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * 路径：com.example.demo.mapper
 * 类名：
 * 功能：《用一句描述一下》
 * 备注：
 * 创建人：typ
 * 创建时间：2018/10/10 14:38
 * 修改人：
 * 修改备注：
 * 修改时间：
 */
@Mapper
public interface ConfigMapper {

    @Select("select id,cron from config where id = #{id}")
    public Config findOne(Integer id);
}
