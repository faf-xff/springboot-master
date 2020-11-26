package com.example.demo.shiro.config;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import com.example.demo.shiro.entity.Resources;
import com.example.demo.shiro.service.ResourcesService;
import com.example.demo.shiro.shiro.MyShiroRealm;
import com.github.pagehelper.util.StringUtil;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.crazycake.shiro.RedisCacheManager;
import org.crazycake.shiro.RedisManager;
import org.crazycake.shiro.RedisSessionDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.apache.shiro.mgt.SecurityManager;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * 路径：com.example.demo.shiro.config
 * 类名：
 * 功能：《用一句描述一下》
 * 备注：
 * 创建人：typ
 * 创建时间：2018/10/9 10:22
 * 修改人：
 * 修改备注：
 * 修改时间：
 */
@Configuration
public class ShiroConfig {

    @Autowired
    private ResourcesService resourcesService;

    @Value("${spring.redis.host}")
    private String host;

    @Value("${spring.redis.port}")
    private int port;

    @Value("${spring.redis.timeout}")
    private int timeout;

    @Value("${spring.redis.password}")
    private String password;

    @Bean
    public static LifecycleBeanPostProcessor getLifecycleBeanPostProcessor() {
        return new LifecycleBeanPostProcessor();
    }
    
    /**
     * 方法名：
     * 功能：ShiroDialect，为了在thymeleaf里使用shiro的标签的bean
     * 描述：
     * 创建人：typ
     * 创建时间：2018/10/9 10:24
     * 修改人：
     * 修改描述：
     * 修改时间：
     */
    @Bean
    public ShiroDialect shiroDialect() {
        return new ShiroDialect();
    }

    /**
     * 方法名：
     * 功能：ShiroFilterFactoryBean 处理拦截资源文件问题。
     *      注意：单独一个ShiroFilterFactoryBean配置是或报错的，因为在初始化ShiroFilterFactoryBean的时候需要注入：SecurityManager
     * 描述： Filter Chain定义说明
     *        1、一个URL可以配置多个Filter，使用逗号分隔
     *        2、当设置多个过滤器时，全部验证通过，才视为通过
     *        3、部分过滤器可指定参数，如perms，roles
     * 创建人：typ
     * 创建时间：2018/10/9 10:25
     * 修改人：
     * 修改描述：
     * 修改时间：
     */
    @Bean
    public ShiroFilterFactoryBean shirFilter(SecurityManager securityManager){
        System.out.println("ShiroConfiguration.shirFilter()");
        ShiroFilterFactoryBean shiroFilterFactoryBean  = new ShiroFilterFactoryBean();

        // 必须设置 SecurityManager
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        // 如果不设置默认会自动寻找Web工程根目录下的"/login.jsp"页面
        shiroFilterFactoryBean.setLoginUrl("/login");
        // 登录成功后要跳转的链接
        shiroFilterFactoryBean.setSuccessUrl("/usersPage");
        //未授权界面;
        shiroFilterFactoryBean.setUnauthorizedUrl("/403");
        //拦截器.
        Map<String,String> filterChainDefinitionMap = new LinkedHashMap<String,String>();

        //配置退出 过滤器,其中的具体的退出代码Shiro已经替我们实现了
        filterChainDefinitionMap.put("/logout", "logout");
        filterChainDefinitionMap.put("/css/**","anon");
        filterChainDefinitionMap.put("/js/**","anon");
        filterChainDefinitionMap.put("/img/**","anon");
        filterChainDefinitionMap.put("/font-awesome/**","anon");
        //<!-- 过滤链定义，从上向下顺序执行，一般将 /**放在最为下边 -->:这是一个坑呢，一不小心代码就不好使了;
        //<!-- authc:所有url都必须认证通过才可以访问; anon:所有url都都可以匿名访问-->
        //自定义加载权限资源关系
        List<Resources> resourcesList = resourcesService.queryAll();
        for(Resources resources:resourcesList){
            if (StringUtil.isNotEmpty(resources.getResurl())) {
                String permission = "perms[" + resources.getResurl()+ "]";
                filterChainDefinitionMap.put(resources.getResurl(),permission);
            }
        }
        filterChainDefinitionMap.put("/**", "authc");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        return shiroFilterFactoryBean;
    }

    @Bean
    public SecurityManager securityManager(){
        DefaultWebSecurityManager securityManager =  new DefaultWebSecurityManager();
        //设置realm.
        securityManager.setRealm(myShiroRealm());
        // 自定义缓存实现 使用redis
        securityManager.setCacheManager(cacheManager());
        // 自定义session管理 使用redis
        securityManager.setSessionManager(sessionManager());
        return securityManager;
    }

    @Bean
    public MyShiroRealm myShiroRealm(){
        MyShiroRealm myShiroRealm = new MyShiroRealm();
        myShiroRealm.setCredentialsMatcher(hashedCredentialsMatcher());
        return myShiroRealm;
    }

    /**
     * 方法名：
     * 功能：凭证匹配器
     *     （由于我们的密码校验交给Shiro的SimpleAuthenticationInfo进行处理了所以我们需要修改下doGetAuthenticationInfo中的代码;)
     * 描述：
     * 创建人：typ
     * 创建时间：2018/10/9 10:29
     * 修改人：
     * 修改描述：
     * 修改时间：
     */
    @Bean
    public HashedCredentialsMatcher hashedCredentialsMatcher(){
        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
        //散列算法:这里使用MD5算法;
        hashedCredentialsMatcher.setHashAlgorithmName("md5");
        //散列的次数，比如散列两次，相当于 md5(md5(""));
        hashedCredentialsMatcher.setHashIterations(2);
        return hashedCredentialsMatcher;
    }

    /**
     * 方法名：
     * 功能：开启shiro aop注解支持.
     * 描述：使用代理方式;所以需要开启代码支持;
     * 创建人：typ
     * 创建时间：2018/10/9 10:30
     * 修改人：
     * 修改描述：
     * 修改时间：
     */
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager){
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
        return authorizationAttributeSourceAdvisor;
    }

    /**
     * 方法名：
     * 功能：配置shiro redisManager
     * 描述：使用的是shiro-redis开源插件
     * 创建人：typ
     * 创建时间：2018/10/9 10:30
     * 修改人：
     * 修改描述：
     * 修改时间：
     */
    public RedisManager redisManager() {
        RedisManager redisManager = new RedisManager();
        redisManager.setHost(host);
        redisManager.setPort(port);
        // 配置缓存过期时间
        redisManager.setExpire(1800);
        redisManager.setTimeout(timeout);
        redisManager.setPassword(password);
        return redisManager;
    }

    /**
     * 方法名：
     * 功能：cacheManager 缓存 redis实现
     * 描述：使用的是shiro-redis开源插件
     * 创建人：typ
     * 创建时间：2018/10/9 10:31
     * 修改人：
     * 修改描述：
     * 修改时间：
     */
    public RedisCacheManager cacheManager() {
        RedisCacheManager redisCacheManager = new RedisCacheManager();
        redisCacheManager.setRedisManager(redisManager());
        return redisCacheManager;
    }

    /**
     * 方法名：
     * 功能：RedisSessionDAO shiro sessionDao层的实现 通过redis
     * 描述：使用的是shiro-redis开源插件
     * 创建人：typ
     * 创建时间：2018/10/9 10:31
     * 修改人：
     * 修改描述：
     * 修改时间：
     */
    @Bean
    public RedisSessionDAO redisSessionDAO() {
        RedisSessionDAO redisSessionDAO = new RedisSessionDAO();
        redisSessionDAO.setRedisManager(redisManager());
        return redisSessionDAO;
    }

    /**
     * 方法名：
     * 功能： shiro session的管理
     * 描述：
     * 创建人：typ
     * 创建时间：2018/10/9 10:31
     * 修改人：
     * 修改描述：
     * 修改时间：
     */
    @Bean
    public DefaultWebSessionManager sessionManager() {
        DefaultWebSessionManager sessionManager = new DefaultWebSessionManager();
        sessionManager.setSessionDAO(redisSessionDAO());
        return sessionManager;
    }

}
