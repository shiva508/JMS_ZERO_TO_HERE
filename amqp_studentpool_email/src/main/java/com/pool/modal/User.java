package com.pool.modal;

import java.io.Serializable;

public class User implements Serializable {
	private Integer userId;
	private String userName;
	private String userType;

	public User() {

	}

	public Integer getUserId() {
		return userId;
	}

	public User setUserId(Integer userId) {
		this.userId = userId;
		return this;
	}

	public String getUserName() {
		return userName;
	}

	public User setUserName(String userName) {
		this.userName = userName;
		return this;
	}

	public String getUserType() {
		return userType;
	}

	public User setUserType(String userType) {
		this.userType = userType;
		return this;
	}

}
