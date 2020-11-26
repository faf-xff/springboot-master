package com.example.demo.shiro.service;


import com.example.demo.shiro.entity.Role;
import com.github.pagehelper.PageInfo;

import java.util.List;

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
public interface RoleService extends IService<Role> {

    public List<Role> queryRoleListWithSelected(Integer uid);

    PageInfo<Role> selectByPage(Role role, int start, int length);

    /**
     * 方法名：
     * 功能：删除角色 同时删除角色资源表中的数据
     * 描述：
     * 创建人：typ
     * 创建时间：2018/10/9 10:47
     * 修改人：
     * 修改描述：
     * 修改时间：
     */
    public void delRole(Integer roleid);
}
