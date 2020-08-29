package com.uprep.userms.reqpojo;

import javax.validation.constraints.NotBlank;

public class LoginPojo {
	@NotBlank(message = "Login ID cannot be blank")
	private String login_id;
	@NotBlank(message = "Password cannot be blank")
	private String password;
	public String getLogin_id() {
		return login_id;
	}
	public void setLogin_id(String login_id) {
		this.login_id = login_id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
