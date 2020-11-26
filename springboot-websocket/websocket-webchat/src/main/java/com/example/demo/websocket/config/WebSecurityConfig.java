package com.example.demo.websocket.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * 路径：com.example.demo.websocket.config
 * 类名：
 * 功能：《用一句描述一下》
 * 备注：
 * 创建人：typ
 * 创建时间：2018/10/18 11:53
 * 修改人：
 * 修改备注：
 * 修改时间：
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{

    /**
     * 方法名：
     * 功能：先设置拦截规则，设置默认登录页面以及登录成功后的跳转页面
     * 描述：
     * 创建人：typ
     * 创建时间：2018/10/18 21:07 
     * 修改人：
     * 修改描述：
     * 修改时间：
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                //设置拦截器
                .antMatchers("/")
                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                //开启默认登录页面
                .formLogin()
                //默认登录页面
                .loginPage("/login")
                //默认登录成功跳转页面
                .defaultSuccessUrl("/chat")
                .permitAll()
                .and()
                //设置注销
                .logout()
                .permitAll();
    }

    /**
     * 方法名：
     * 功能：定义两个用户，设置用户名、用户密码、用户角色等信息。
     * 描述：
     * 创建人：typ
     * 创建时间：2018/10/18 21:07
     * 修改人：
     * 修改描述：
     * 修改时间：
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .passwordEncoder(new PasswordEncoderConfig())
                .withUser("admin").password("admin").roles("USER")
                .and()
                .withUser("root").password("root").roles("USER");
    }

    /**
     * 方法名：
     * 功能：设置静态资源不被拦截。
     * 描述：
     * 创建人：typ
     * 创建时间：2018/10/18 21:08
     * 修改人：
     * 修改描述：
     * 修改时间：
     */
    @Override
    public void configure(WebSecurity web) throws Exception {
        //设置不拦截规则
        web.ignoring().antMatchers("/resources/static/**");
    }
}

