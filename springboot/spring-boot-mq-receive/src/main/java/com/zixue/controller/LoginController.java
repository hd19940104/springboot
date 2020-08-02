package com.zixue.controller;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.zixue.beans.User;
import com.zixue.service.UserRestService;

@Controller
public class LoginController {
	private static Logger logger = Logger.getLogger(LoginController.class);
	private static final String KEY_LOGIN_="KEY_LOGIN_";
	@Autowired
	private UserRestService userService;
	@Autowired
	private StringRedisTemplate redis;

	@RequestMapping({ "/" })
	public String index() {
		logger.info("首页");
		return "redirect:/login";
	}

	@RequestMapping({ "/login" })
	public String login() {
		return "login";
	}

	@RequestMapping({ "/hello" })
	public String hello() {
		return "hello";
	}

	@RequestMapping({ "/registers" })
	public String registers() {
		return "register";
	}

	@PostMapping({ "/register" })
	public ModelAndView register(@RequestParam("username") String username, @RequestParam("password") String password,
			@RequestParam("password2") String password2) {
		ModelAndView success = new ModelAndView();

		if ((username.isEmpty()) || (password.isEmpty()) || (password2.isEmpty())) {
			success.setViewName("register");
			success.addObject("tip1", "用户或密码不能为空");
			return success;
		}

		if (!password.equals(password2)) {
			success.setViewName("register");
			success.addObject("tip2", "两次密码不一样");
			return success;
		}

		User us = this.userService.findUserByName(username);
		if (us == null) {
			User registers = new User();
			registers.setPassword(password);
			registers.setName(username);
			this.userService.addUser(registers);
			success.setViewName("login");
		} else {
			success.setViewName("404");
		}
		return success;
	}

	@PostMapping({ "/login_" })
	public ModelAndView Login(@RequestParam("username") String username,
			@RequestParam("userpassword") String userpassword) {
		ModelAndView success = new ModelAndView();
		User user = new User();
		logger.info(redis);
		// 查询缓存
		String passw = (String) redis.opsForList().leftPop(KEY_LOGIN_+username);
		if (passw != null) {
			if (passw.equals(userpassword)) {
				user.setPassword(passw);
			}
		} else {
			user = this.userService.findUserByName(username);
		}

		if (user != null) {
			String dbpassword = user.getPassword();
			if (userpassword.equals(dbpassword)) {
				// 保存缓存
				redis.opsForList().leftPush(KEY_LOGIN_+username, userpassword);
				redis.expire(KEY_LOGIN_+username, 1000*60*60, TimeUnit.SECONDS);
				success.setViewName("redirect:/list");
			} else {
				success.setViewName("login");
			}
		} else {
			success.setViewName("login");
		}

		return success;
	}
}
