package com.example.demo.shiro;

import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;


/**
 * 路径：com.example.demo.shiro
 * 类名：
 * 功能：《用一句描述一下》
 * 备注：
 * 创建人：typ
 * 创建时间：2018/10/8 17:50
 * 修改人：
 * 修改备注：
 * 修改时间：
 */
@Slf4j
public class ShiroTest {

    public static void main(String[] args) {
        //1.创建 SecurityManager
        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro.ini");

        //2.解析配置文件，并返回一些 SecurityManager
        SecurityManager securityManager = factory.getInstance();

        //3.将SecurityManager
        SecurityUtils.setSecurityManager(securityManager);

        //安全操作，Subject
        Subject currentUser = SecurityUtils.getSubject();

        //测试在应用的当前会话中设置的属性
        Session session = currentUser.getSession();

        //放进去一个key
        session.setAttribute("someKey", "aValue");

        //根据key获取value
        String value = (String) session.getAttribute("someKey");
        //比较拿到的值和原来的值是否一致
        if ("aValue".equals(value)) {
            log.info("检索到正确的值[" + value + "]");
        }

        //尝试进行登录用户，如果登录失败了，我们进行一些处理
        if (!currentUser.isAuthenticated()) {
            //如果用户没有登录过
            UsernamePasswordToken token = new UsernamePasswordToken("test", "123456");
            //是否记住用户
            token.setRememberMe(true);
            try {
                currentUser.login(token);
                //当我们获登录用户之后
                log.info("用户 [" + currentUser.getPrincipal() + "] 登陆成功");
                // 查看用户是否有指定的角色
                if (currentUser.hasRole("admin")) {
                    log.info("您有admin角色");
                } else {
                    log.info("您没有admin角色");
                }
                if (currentUser.hasRole("role1")) {
                    log.info("您有role1角色");
                } else {
                    log.info("您没有role1角色");
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

}
