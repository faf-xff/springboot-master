package com.example.demo.shiro;

import com.example.demo.shiro.entity.User;
import org.crazycake.shiro.RedisManager;
import org.crazycake.shiro.SerializeUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ShiroMybatisRedisApplicationTests {

	@Autowired
	private JedisPool jedisPool;

	@Test
	public void test(){
		Jedis jedis = jedisPool.getResource();
		User user = new User();
		user.setId(2);
		user.setUsername("admin");
		user.setPassword("3esdfffdsdfergfwdfdsfsdfewer");
		user.setEnable(1);
		byte[] serialize = SerializeUtils.serialize(user);
		jedis.set(serialize,"testvalue".getBytes());
	}



	@Test
	public void test2(){
		Jedis jedis = jedisPool.getResource();
		User user = new User();
		user.setId(2);
		user.setUsername("admin");
		user.setPassword("3esdfffdsdfergfwdfdsfsdfewer");
		user.setEnable(1);
		byte[] serialize = SerializeUtils.serialize(user);
		jedis.del(serialize);
	}

}
