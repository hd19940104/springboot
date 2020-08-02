package com.zixue.controller;

import java.util.concurrent.TimeUnit;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestRedisController {


	@javax.annotation.Resource(name="redisTwo")
	private  RedisTemplate  redisTemplate;
	@SuppressWarnings("unchecked")
	@RequestMapping("/setRedisConf")
	public String setRedisConf() {
		String key = "KEY_" + System.currentTimeMillis();
		String value = System.currentTimeMillis() + "";
		this.redisTemplate.opsForValue().set(key, value);
		Boolean expire = this.redisTemplate.expire(key, 10L, TimeUnit.HOURS);
		if (expire.booleanValue()) {
			return "key----【" + this.redisTemplate.opsForValue().get(key) + "】";
		}else {
			return "success";
		}
		
	}
	

}
