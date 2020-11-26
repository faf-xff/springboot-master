package com.example.demo.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PerformanceInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 路径：com.example.demo.config
 * 类名：
 * 功能：MybatisPlus配置文件
 * 备注：
 * 创建人：typ
 * 创建时间：2018/11/23 15:56
 * 修改人：
 * 修改备注：
 * 修改时间：
 */
@EnableTransactionManagement
@Configuration
@MapperScan("com.example.demo.*.mapper")
public class MybatisPlusConfig {

    /**
     * 方法名：
     * 功能：mybatis-plus分页插件
     * 描述：
     * 创建人：typ
     * 创建时间：2018/11/23 15:57
     * 修改人：
     * 修改描述：
     * 修改时间：
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }

    /**
     * 方法名：
     * 功能：打印 sql
     * 描述：SQL执行效率插件【生产环境可以关闭】
     * 创建人：typ
     * 创建时间：2018/11/27 9:58
     * 修改人：
     * 修改描述：
     * 修改时间：
     */
    @Bean
    public PerformanceInterceptor performanceInterceptor() {
        PerformanceInterceptor performanceInterceptor = new PerformanceInterceptor();
        performanceInterceptor.setFormat(true);
        return performanceInterceptor;
    }



}
