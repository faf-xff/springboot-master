package com.example.demo;

import com.example.demo.entity.Config;
import com.example.demo.mapper.ConfigMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootQuartzApplicationTests {

	@Autowired
	ConfigMapper configMapper;


	@Test
	public void contextLoads() {

		Config config = configMapper.findOne(1);

		System.out.println(config.getCron());
	}

}
