package com.example.demo.websocket.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * 路径：com.example.demo.websocket.config
 * 类名：
 * 功能：《用一句描述一下》
 * 备注：为ws.html提供路径映射
 * 创建人：typ
 * 创建时间：2018/10/18 10:34
 * 修改人：
 * 修改备注：
 * 修改时间：
 */
@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/ws").setViewName("/ws");
    }

}
