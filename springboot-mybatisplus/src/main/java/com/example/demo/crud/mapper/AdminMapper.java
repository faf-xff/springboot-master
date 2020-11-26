package com.example.demo.crud.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.crud.entity.Admin;
import com.example.demo.crud.entity.AdminUserOV;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 路径：com.example.demo.crud.mapper
 * 类名：
 * 功能：《用一句描述一下》
 * 备注：
 * 创建人：typ
 * 创建时间：2018/11/27 10:29
 * 修改人：
 * 修改备注：
 * 修改时间：
 */
public interface AdminMapper extends BaseMapper<Admin> {

    @Select("select a.*,u.* from admin a,user u where a.user_id = u.id")
    List<AdminUserOV> find(Page<AdminUserOV> page);
}
