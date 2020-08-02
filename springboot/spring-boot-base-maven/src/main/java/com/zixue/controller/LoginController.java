package com.zixue.controller;

import com.zixue.beans.User;
import com.zixue.service.UserRestService;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
	private static Logger logger = Logger.getLogger(LoginController.class);

	@Autowired
	private UserRestService userService;

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
		User user = this.userService.findUserByName(username);
		if (user != null) {
			String dbpassword = user.getPassword();
			if (dbpassword.equals(userpassword))
				success.setViewName("redirect:/list");
			else
				success.setViewName("login");
		} else {
			success.setViewName("login");
		}

		return success;
	}
}
