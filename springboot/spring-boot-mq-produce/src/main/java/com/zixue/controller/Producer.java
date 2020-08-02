
package com.zixue.controller;

import java.util.UUID;

import javax.jms.Queue;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;
import com.zixue.beans.User;


@Component
@EnableScheduling
public class Producer {
	@Autowired
	private JmsMessagingTemplate jmsMessagingTemplate;
	@Autowired
	private Queue queue;
	private int age = 18;

	@Scheduled(fixedDelay = 3000)
	public void send() {
		age++;
		String msg ="this is test-msg";
		User user = new User();
		user.setAge(age);
		user.setName("user_"+age);
		user.setPassword(UUID.randomUUID().toString());
		
		JSONObject jsonObject = new JSONObject();
		String jsonString = jsonObject.toJSONString(user);
		System.out.println(jsonString);
	
		jmsMessagingTemplate.convertAndSend(queue, jsonString);
	}

}
