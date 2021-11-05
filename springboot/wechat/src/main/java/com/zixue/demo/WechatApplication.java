package com.zixue.demo;

import com.zixue.demo.dao.MessageInfoMapper;
import com.zixue.demo.dto.model.MessageInfoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.Objects;

@SpringBootApplication
@Controller
public class WechatApplication {

	public static void main(String[] args) {
		SpringApplication.run(WechatApplication.class, args);
	}
	@Autowired
	private MessageInfoMapper messageInfoMapper;

	@RequestMapping("hello")
	@ResponseBody
	public String hello() {


		MessageInfoDto record = new MessageInfoDto();
		record.setUpdateTime(new Date());
		messageInfoMapper.insertSelective(record);
		return "hello world";
	}
}
