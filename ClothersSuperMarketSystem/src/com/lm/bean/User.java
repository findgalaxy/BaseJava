package com.lm.bean;

import java.io.Serializable;

public class User implements Serializable{
	private String username;//用户名称
	private int id;
	private String password;//用户密码
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public User(String username, int id, String password) {
		super();
		this.username = username;
		this.id = id;
		this.password = password;
	}
	public User() {
		super();
	}
	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
}
