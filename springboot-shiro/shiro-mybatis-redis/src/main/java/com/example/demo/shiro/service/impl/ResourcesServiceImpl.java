package com.example.demo.shiro.service.impl;

import com.example.demo.shiro.entity.Resources;
import com.example.demo.shiro.mapper.ResourcesMapper;
import com.example.demo.shiro.service.ResourcesService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 路径：com.example.demo.shiro.service.impl
 * 类名：
 * 功能：《用一句描述一下》
 * 备注：
 * 创建人：typ
 * 创建时间：2018/10/9 10:45
 * 修改人：
 * 修改备注：
 * 修改时间：
 */
@Slf4j
@Service
public class ResourcesServiceImpl extends BaseService<Resources> implements ResourcesService {
   @Resource
    private ResourcesMapper resourcesMapper;

    @Override
    public PageInfo<Resources> selectByPage(Resources resources, int start, int length) {
        PageHelper.startPage(start,length);
        Example example = new Example(Resources.class);
        List<Resources> userList = selectByExample(example);
        PageInfo<Resources> pageInfo=new PageInfo<>(userList);
        return pageInfo;
    }

    @Override
    public List<Resources> queryAll(){
        return resourcesMapper.queryAll();
    }

    @Override
    public List<Resources> loadUserResources(Map<String, Object> map) {
        return resourcesMapper.loadUserResources(map);
    }

    @Override
    public List<Resources> queryResourcesListWithSelected(Integer rid) {
        return resourcesMapper.queryResourcesListWithSelected(rid);
    }
}
