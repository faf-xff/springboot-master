package com.example.demo.shiro.shiro;

import com.example.demo.shiro.entity.Resources;
import com.example.demo.shiro.entity.User;
import com.example.demo.shiro.service.ResourcesService;
import com.example.demo.shiro.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.mgt.RealmSecurityManager;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.apache.shiro.subject.support.DefaultSubjectContext;
import org.apache.shiro.util.ByteSource;
import org.crazycake.shiro.RedisSessionDAO;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import java.util.*;

/**
 * 路径：com.example.demo.shiro.shiro
 * 类名：
 * 功能：《用一句描述一下》
 * 备注：
 * 创建人：typ
 * 创建时间：2018/10/9 10:32
 * 修改人：
 * 修改备注：
 * 修改时间：
 */
public class MyShiroRealm extends AuthorizingRealm {

    @Resource
    private UserService userService;

    @Resource
    private ResourcesService resourcesService;

    @Autowired
    private RedisSessionDAO redisSessionDAO;

    /**
     * 方法名：
     * 功能：授权
     * 描述：
     * 创建人：typ
     * 创建时间：2018/10/9 10:35
     * 修改人：
     * 修改描述：
     * 修改时间：
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        User user= (User) SecurityUtils.getSubject().getPrincipal();
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("userid",user.getId());
        List<Resources> resourcesList = resourcesService.loadUserResources(map);
        // 权限信息对象info,用来存放查出的用户的所有的角色（role）及权限（permission）
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        for(Resources resources: resourcesList){
            info.addStringPermission(resources.getResurl());
        }
        return info;
    }

    /**
     * 方法名：
     * 功能：认证
     * 描述：
     * 创建人：typ
     * 创建时间：2018/10/9 10:35
     * 修改人：
     * 修改描述：
     * 修改时间：
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        //获取用户的输入的账号.
        String username = (String)token.getPrincipal();
        User user = userService.selectByUsername(username);
        if(user==null) throw new UnknownAccountException();
        if (0==user.getEnable()) {
            throw new LockedAccountException(); // 帐号锁定
        }
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(
                user, //用户
                user.getPassword(), //密码
                ByteSource.Util.bytes(username),
                getName()  //realm name
        );
        // 当验证都通过后，把用户信息放在session里
        Session session = SecurityUtils.getSubject().getSession();
        session.setAttribute("userSession", user);
        session.setAttribute("userSessionId", user.getId());
        return authenticationInfo;
    }

    /**
     * 方法名：
     * 功能：根据userId 清除当前session存在的用户的权限缓存
     * 描述：userIds 已经修改了权限的userId
     * 创建人：typ
     * 创建时间：2018/10/9 10:34
     * 修改人：
     * 修改描述：
     * 修改时间：
     */
    public void clearUserAuthByUserId(List<Integer> userIds){
        if(null == userIds || userIds.size() == 0)	return ;
        //获取所有session
        Collection<Session> sessions = redisSessionDAO.getActiveSessions();
        //定义返回
        List<SimplePrincipalCollection> list = new ArrayList<SimplePrincipalCollection>();
        for (Session session:sessions){
            //获取session登录信息。
            Object obj = session.getAttribute(DefaultSubjectContext.PRINCIPALS_SESSION_KEY);
            if(null != obj && obj instanceof SimplePrincipalCollection){
                //强转
                SimplePrincipalCollection spc = (SimplePrincipalCollection)obj;
                //判断用户，匹配用户ID。
                obj = spc.getPrimaryPrincipal();
                if(null != obj && obj instanceof User){
                    User user = (User) obj;
                    System.out.println("user:"+user);
                    //比较用户ID，符合即加入集合
                    if(null != user && userIds.contains(user.getId())){
                        list.add(spc);
                    }
                }
            }
        }
        RealmSecurityManager securityManager = (RealmSecurityManager) SecurityUtils.getSecurityManager();
        MyShiroRealm realm = (MyShiroRealm)securityManager.getRealms().iterator().next();
        for (SimplePrincipalCollection simplePrincipalCollection : list) {
            realm.clearCachedAuthorizationInfo(simplePrincipalCollection);
        }
    }
}
