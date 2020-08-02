package com.zixue.activemq.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.zixue.beans.User;
import com.zixue.mapper.UserRestMapper;

@Service
public class MessageConsumerService {
	@Autowired
	private UserRestMapper map;
	@SuppressWarnings("static-access")
	@JmsListener(destination="${queue}")
	public void receiveMessage(String text) {	// 进行消息接收处理
		JSONObject jsonObject = new JSONObject();
		User user = jsonObject.parseObject(text, User.class);
		if (user!=null) {
			map.insertUser(user);
		}
		System.err.println("【*** 接收消息 ***】" + user.toString());
	}
}
