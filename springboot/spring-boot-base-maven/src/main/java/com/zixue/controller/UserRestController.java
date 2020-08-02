package com.zixue.controller;

import com.zixue.beans.User;
import com.zixue.service.UserRestService;
import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserRestController {
	private static Logger logger = Logger.getLogger(UserRestController.class);

	@Autowired
	private UserRestService userService;

	@Autowired
	private CacheManager cacheManager;

	@RequestMapping({ "/list" })
	public String list(Model model) {
		System.out.println("Thymeleaf查询所有");

		List users = this.userService.findAll();
		model.addAttribute("users", users);
		return "user/list";
	}

	@RequestMapping({ "/toAdd" })
	public String toAdd() {
		return "user/userAdd";
	}

	@RequestMapping({ "/add" })
	public String add(User user) {
		this.userService.addUser(user);
		return "redirect:/list";
	}

	@RequestMapping({ "/removeCache" })
	public String removeCache() {
		if (this.cacheManager != null) {
			logger.info("------baseCache---------" + this.cacheManager.getCache("baseCache").toString());
		}

		return "redirect:/list";
	}

	@RequestMapping({ "/toEdit" })
	public String toEdit(Model model, int id) {
		User user = this.userService.findUserById(Integer.valueOf(id));
		model.addAttribute("user", user);
		return "user/userEdit";
	}

	@RequestMapping({ "/edit" })
	public String edit(User user) {
		this.userService.updateUser(user);
		return "redirect:/list";
	}

	@RequestMapping({ "/toDelete" })
	public String delete(int id) {
		this.userService.deleteUser(Integer.valueOf(id));
		return "redirect:/list";
	}
}
