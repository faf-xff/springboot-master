package com.example.demo.shiro.controller;

import com.example.demo.shiro.entity.Role;
import com.example.demo.shiro.entity.RoleResources;
import com.example.demo.shiro.service.RoleResourcesService;
import com.example.demo.shiro.service.RoleService;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 路径：com.example.demo.shiro.controller
 * 类名：
 * 功能：
 * 备注：
 * 创建人：typ
 * 创建时间：2018/10/9 9:53
 * 修改人：
 * 修改备注：
 * 修改时间：
 */
@Slf4j
@RestController
@RequestMapping("/roles")
public class RoleController {
    @Resource
    private RoleService roleService;
    @Resource
    private RoleResourcesService roleResourcesService;

    @RequestMapping
    public  Map<String,Object> getAll(Role role, String draw,
                                      @RequestParam(required = false, defaultValue = "1") int start,
                                      @RequestParam(required = false, defaultValue = "10") int length){

        Map<String,Object> map = new HashMap<>();
        PageInfo<Role> pageInfo = roleService.selectByPage(role, start, length);
        map.put("draw",draw);
        map.put("recordsTotal",pageInfo.getTotal());
        map.put("recordsFiltered",pageInfo.getTotal());
        map.put("data", pageInfo.getList());
        return map;
    }

    @RequestMapping("/rolesWithSelected")
    public List<Role> rolesWithSelected(Integer uid){
        return roleService.queryRoleListWithSelected(uid);
    }

    /**
     * 方法名：
     * 功能：分配角色
     * 描述：
     * 创建人：typ
     * 创建时间：2018/10/9 10:59
     * 修改人：
     * 修改描述：
     * 修改时间：
     */
    @RequestMapping("/saveRoleResources")
    public String saveRoleResources(RoleResources roleResources){
        if(StringUtils.isEmpty(roleResources.getRoleid()))
            return "error";
        try {
            roleResourcesService.addRoleResources(roleResources);
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
    }

    @RequestMapping(value = "/add")
    public String add(Role role) {
        try {
            roleService.save(role);
            return "success";
        } catch (Exception e) {
            e.printStackTrace();
            return "fail";
        }
    }

    @RequestMapping(value = "/delete")
    public String delete(Integer id){
        try{
            roleService.delRole(id);
            return "success";
        }catch (Exception e){
            e.printStackTrace();
            return "fail";
        }
    }



}
