package com.zixue.beans;

public class User {
	private int id;
	private String name;
	private String password;
	private Integer age;

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getAge() {
		return this.age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String toString() {
		return "User [id=" + this.id + ", name=" + this.name + ", password=" + this.password + ", age=" + this.age
				+ "]";
	}
}
