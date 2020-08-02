package com.zixue.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zixue.beans.User;
import com.zixue.service.UserRestService;

@Controller
public class UserRestController {
	private static Logger logger = Logger.getLogger(UserRestController.class);

	@Autowired
	private UserRestService userService;

	@Autowired
	private CacheManager cacheManager;

	// @CrossOrigin(origins = "http://localhost:8080")//解决跨域
	@RequestMapping({ "/list" })
	public String list(Model model,@RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "10") Integer pageSize) {
		//引入分页查询，使用PageHelper分页功能在查询之前传入当前页，然后多少记录
	    PageHelper.startPage(pageNum, pageSize);
	    //startPage后紧跟的这个查询就是分页查询
		List users = this.userService.findAll();
		//使用PageInfo包装查询结果，只需要将pageInfo交给页面就可以
	    PageInfo pageInfo = new PageInfo<User>(users, 5);
	    System.out.println(pageInfo);
	    //PageInfo{pageNum=1, pageSize=30, size=30, startRow=1, 
	    //endRow=30, total=345, pages=12, list=Page{count=true, 
	    //pageNum=1, pageSize=30, startRow=0, endRow=30, total=345, pages=12,
	    //countSignal=false, orderBy='null', orderByOnly=false,
	    //reasonable=true, pageSizeZero=false}, firstPage=1, prePage=0,
	    //nextPage=2, lastPage=5, isFirstPage=true, isLastPage=false, hasPreviousPage=false, 
	    //hasNextPage=true, navigatePages=5, navigatepageNums=[1, 2, 3, 4, 5]}
	    model.addAttribute("users", users);
	  //获得当前页
	    model.addAttribute("pageNum", pageInfo.getPageNum());
	    //获得一页显示的条数
	    model.addAttribute("pageSize", pageInfo.getPageSize());
	    //是否是第一页
	    model.addAttribute("isFirstPage", pageInfo.isIsFirstPage());
	    //获得总页数
	    model.addAttribute("totalPages", pageInfo.getPages());
	    //是否是最后一页
	    model.addAttribute("isLastPage", pageInfo.isIsLastPage());
		return "user/list";
	}

	@RequestMapping({ "/list_" })
	public String list_(Model model,@RequestParam(defaultValue = "1") Integer pageNum, @RequestParam(defaultValue = "10") Integer pageSize) {
		//引入分页查询，使用PageHelper分页功能在查询之前传入当前页，然后多少记录
	    PageHelper.startPage(pageNum, pageSize);
	    //startPage后紧跟的这个查询就是分页查询
		List users = this.userService.selectAll();
		//使用PageInfo包装查询结果，只需要将pageInfo交给页面就可以
	    PageInfo pageInfo = new PageInfo<User>(users, 5);
	    System.out.println(pageInfo);
	    //PageInfo{pageNum=1, pageSize=30, size=30, startRow=1, 
	    //endRow=30, total=345, pages=12, list=Page{count=true, 
	    //pageNum=1, pageSize=30, startRow=0, endRow=30, total=345, pages=12,
	    //countSignal=false, orderBy='null', orderByOnly=false,
	    //reasonable=true, pageSizeZero=false}, firstPage=1, prePage=0,
	    //nextPage=2, lastPage=5, isFirstPage=true, isLastPage=false, hasPreviousPage=false, 
	    //hasNextPage=true, navigatePages=5, navigatepageNums=[1, 2, 3, 4, 5]}
	    model.addAttribute("users", users);
	  //获得当前页
	    model.addAttribute("pageNum", pageInfo.getPageNum());
	    //获得一页显示的条数
	    model.addAttribute("pageSize", pageInfo.getPageSize());
	    //是否是第一页
	    model.addAttribute("isFirstPage", pageInfo.isIsFirstPage());
	    //获得总页数
	    model.addAttribute("totalPages", pageInfo.getPages());
	    //是否是最后一页
	    model.addAttribute("isLastPage", pageInfo.isIsLastPage());
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
