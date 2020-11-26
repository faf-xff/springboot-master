package com.example.demo.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * @path：com.example.demo.config.DataSourceConfig.java
 * @className：DataSourceConfig.java
 * @description：多数据源配置
 * @author：tanyp
 * @dateTime：2020/10/12 10:50 
 * @editNote：
 */
@Configuration
public class DataSourceConfig {

    /**
     * @methodName：db1DataSource
     * @description： 数据源db1
     *            @Primary：表示主的，即出现多个bean的时候如果不指定具体的bean，则会采用这个
     * @author：tanyp
     * @dateTime：2020/10/12 10:56
     * @Params： []
     * @Return： javax.sql.DataSource
     * @editNote：
     */
    @Primary
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.db1")
    public DataSource db1DataSource() {
        return DataSourceBuilder.create().build();
    }

    /**
     * @methodName：db2DataSource
     * @description：数据源db2
     * @author：tanyp
     * @dateTime：2020/10/12 10:57
     * @Params： []
     * @Return： javax.sql.DataSource
     * @editNote：
     */
    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.db2")
    public DataSource db2DataSource() {
        return DataSourceBuilder.create().build();
    }

    /**
     * @methodName：db1JdbcTemplate
     * @description：配置JdbcTemplate对象
     *      @Qualifier：bean类型相同后，指定使用的bean的name
     * @author：tanyp
     * @dateTime：2020/10/12 11:08
     * @Params： [dataSource]
     * @Return： org.springframework.jdbc.core.JdbcTemplate
     * @editNote：
     */
    @Primary
    @Bean
    public JdbcTemplate db1JdbcTemplate(@Qualifier("db1DataSource") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    /**
     * @methodName：db2JdbcTemplate
     * @description：配置JdbcTemplate对象
     *      @Qualifier：bean类型相同后，指定使用的bean的name
     * @author：tanyp
     * @dateTime：2020/10/12 11:08
     * @Params： [dataSource]
     * @Return： org.springframework.jdbc.core.JdbcTemplate
     * @editNote：
     */
    @Bean
    public JdbcTemplate db2JdbcTemplate(@Qualifier("db2DataSource") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

}



