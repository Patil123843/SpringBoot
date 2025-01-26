package com.tech.entity;

public class User {
	
	private String userid;
	private String name;
	private String email;
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public User(String userid, String name, String email) {
		super();
		this.userid = userid;
		this.name = name;
		this.email = email;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
}
