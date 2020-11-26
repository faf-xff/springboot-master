package com.example.demo.shiro;

import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.apache.shiro.mgt.SecurityManager;

/**
 * 路径：com.example.demo.shiro
 * 类名：
 * 功能：Shiro+MySQL动态权限验证
 * 备注：
 * 创建人：typ
 * 创建时间：2018/10/8 21:57
 * 修改人：
 * 修改备注：
 * 修改时间：
 */
@Slf4j
public class ShiroMysqlTest {

    public static void main(String[] args) {
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro-mysql.ini");
        SecurityManager securityManager = factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);
        Subject currentUser = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken("test@shiro.com", "123456");
        //是否记住用户
        token.setRememberMe(true);
        try {
            currentUser.login(token);
            //当我们获登录用户之后
            log.info("用户 [" + currentUser.getPrincipal() + "] 登陆成功");
            //查看用户是否有角色
            if (currentUser.hasRole("admin")) {
                log.info("您有admin角色");
            } else {
                log.info("您没有admin角色");
            }
            if (currentUser.hasRole("test")) {
                log.info("您有test角色");
            } else {
                log.info("您没有test角色");
            }
            // 查看用户是否有某个权限
            if (currentUser.isPermitted("perm1")) {
                log.info("您有perm1权限");
            } else {
                log.info("您没有perm1权限");
            }
            if (currentUser.isPermitted("guest")) {
                log.info("您有guest权限");
            } else {
                log.info("您没有guest权限");
            }
            //退出
            currentUser.logout();
        } catch (UnknownAccountException uae) {
            log.info(token.getPrincipal() + "账户不存在");
        } catch (IncorrectCredentialsException ice) {
            log.info(token.getPrincipal() + "密码不正确");
        } catch (LockedAccountException lae) {
            log.info(token.getPrincipal() + "用户被锁定了 ");
        } catch (AuthenticationException ae) {
            //无法判断是什么错了
            log.info(ae.getMessage());
        }
    }

}
