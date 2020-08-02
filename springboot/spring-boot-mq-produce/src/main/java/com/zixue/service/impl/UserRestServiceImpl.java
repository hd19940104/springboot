package com.zixue.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zixue.beans.User;
import com.zixue.mapper.UserRestMapper;
import com.zixue.service.UserRestService;

@Service
@Transactional
public class UserRestServiceImpl implements UserRestService {

	@Autowired
	private UserRestMapper map;
	
	public int addUser(User user) {
		return this.map.insertUser(user);
	}

	public int updateUser(User user) {
		return this.map.updateUser(user);
	}

	public int deleteUser(Integer id) {
		return this.map.deleteUser(id.intValue());
	}

	public User findUserById(Integer id) {
		return this.map.findUserById(id.intValue());
	}

	public List<User> findAll() {
		return this.map.findUserAll();
	}
	public List<User> selectAll() {
		return this.map.findUserAll();
	}
	public User findUserByName(String name) {
		return this.map.findUserByName(name);
	}

	
}
