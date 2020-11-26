package com.example.demo.shiro.service.impl;

import com.example.demo.shiro.entity.RoleResources;
import com.example.demo.shiro.mapper.UserRoleMapper;
import com.example.demo.shiro.service.RoleResourcesService;
import com.example.demo.shiro.shiro.MyShiroRealm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;

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
public class RoleResourcesServiceImpl extends BaseService<RoleResources> implements RoleResourcesService {

    @Resource
    private UserRoleMapper userRoleMapper;

    @Autowired
    private MyShiroRealm myShiroRealm;

    /**
     * 方法名：
     * 功能： 更新权限
     * 描述：
     * 创建人：typ
     * 创建时间：2018/10/9 14:43
     * 修改人：
     * 修改描述：
     * 修改时间：
     */
    @Override
    @Transactional(propagation= Propagation.REQUIRED,readOnly=false,rollbackFor={Exception.class})
    public void addRoleResources(RoleResources roleResources) {
        //删除
        Example example = new Example(RoleResources.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("roleid",roleResources.getRoleid());
        mapper.deleteByExample(example);
        //添加
        if(!StringUtils.isEmpty(roleResources.getResourcesid())){
            String[] resourcesArr = roleResources.getResourcesid().split(",");
            for(String resourcesId:resourcesArr ){
                RoleResources r = new RoleResources();
                r.setRoleid(roleResources.getRoleid());
                r.setResourcesid(resourcesId);
                mapper.insert(r);
            }
        }

        List<Integer> userIds= userRoleMapper.findUserIdByRoleId(roleResources.getRoleid());
        //更新当前登录的用户的权限缓存
        myShiroRealm.clearUserAuthByUserId(userIds);


    }
}
