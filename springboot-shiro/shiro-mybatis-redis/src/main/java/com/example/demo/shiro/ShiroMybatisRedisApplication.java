package com.example.demo.shiro;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@MapperScan(basePackages = "com.example.demo.shiro.mapper")
public class ShiroMybatisRedisApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShiroMybatisRedisApplication.class, args);
	}
}
