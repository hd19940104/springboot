package com.zixue.controller.rest;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.zixue.beans.User;


@RestController
public class MemberController {
	@RequestMapping(value = "/member/add",method=RequestMethod.POST)
	public Object add(@RequestBody User user) {	// 表示当前的配置可以直接将参数变为VO对象
		System.err.println("【MemberController.add()接收对象】" + user);
		return true;
	}
	@RequestMapping(value = "/member/get/{mid}",method=RequestMethod.GET)
	public User get(@PathVariable("mid") long mid) {
		User vo = new User();
		vo.setAge(20);
		vo.setName("zixue");
		vo.setPassword("admin");
		return vo;
	}
}
