package com.zixue.controller.rest;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import com.zixue.beans.User;
import com.zixue.controller.AbstractBaseController;

@Controller
public class MemberConsumerController extends AbstractBaseController {
	@Resource
	private RestTemplate restTemplate;
	@RequestMapping(value = "/consumer/get", method = RequestMethod.GET)
	public String getMember(long mid,Model model) {
		User user = this.restTemplate.getForObject(
				"http://localhost:8080/member/get/" + mid, User.class);
		model.addAttribute("user", user) ;
		return "member_show";
	}
	@RequestMapping(value = "/consumer/add", method = RequestMethod.GET)
	@ResponseBody
	public Object addMember(User user ) {
		Boolean flag = this.restTemplate.postForObject(
				"http://localhost:8080/user/add", user, Boolean.class);
		return flag;
	}
}
