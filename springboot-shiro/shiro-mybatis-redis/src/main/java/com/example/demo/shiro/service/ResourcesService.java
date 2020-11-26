package com.example.demo.shiro.service;

import com.example.demo.shiro.entity.Resources;
import com.github.pagehelper.PageInfo;

import java.util.List;
import java.util.Map;

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
public interface ResourcesService extends IService<Resources>  {

    PageInfo<Resources> selectByPage(Resources resources, int start, int length);

    public List<Resources> queryAll();

    public List<Resources> loadUserResources(Map<String,Object> map);

    public List<Resources> queryResourcesListWithSelected(Integer rid);
}
