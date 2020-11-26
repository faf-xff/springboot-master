package com.example.demo.activemq;

import org.apache.activemq.command.ActiveMQQueue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ActivemqRedisApplication {

	private static final Logger log = LoggerFactory.getLogger(ActivemqRedisApplication.class);

	@Bean
	public ActiveMQQueue queue(){
		return new ActiveMQQueue("promoteAct");
	}

	public static void main(String[] args) {
		SpringApplication.run(ActivemqRedisApplication.class, args);

		log.info("SpringBoot Start Success");
	}
}
