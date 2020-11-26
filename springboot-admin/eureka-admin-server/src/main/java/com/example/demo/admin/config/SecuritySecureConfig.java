package com.example.demo.admin.config;

import de.codecentric.boot.admin.server.config.AdminServerProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

/**
 * 路径：com.example.demo.admin.config
 * 类名：
 * 功能：《用一句描述一下》
 * 备注：
 * 创建人：typ
 * 创建时间：2019/1/11 11:05
 * 修改人：
 * 修改备注：
 * 修改时间：
 */
@Configuration
public class SecuritySecureConfig extends WebSecurityConfigurerAdapter{

    private final String adminContextPath;

    public SecuritySecureConfig(AdminServerProperties adminServerProperties){
        this.adminContextPath = adminServerProperties.getContextPath();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        SavedRequestAwareAuthenticationSuccessHandler successHandler = new SavedRequestAwareAuthenticationSuccessHandler();
        successHandler.setTargetUrlParameter("redirectTo");
        http.authorizeRequests()
                .antMatchers(adminContextPath + "/assets/**").permitAll()
                .antMatchers(adminContextPath + "/login").permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .formLogin().loginPage(adminContextPath + "/login").successHandler(successHandler )
                .and()
                .logout().logoutUrl(adminContextPath+"/logout")
                .and()
                .httpBasic()
                .and()
                .csrf()
                .disable();
    }
}
