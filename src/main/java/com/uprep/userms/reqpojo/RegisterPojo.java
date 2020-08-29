package com.uprep.userms.reqpojo;

import javax.validation.constraints.NotBlank;

public class RegisterPojo {

	@NotBlank(message = "Login ID cannot be blank")
	private String login_id;
	@NotBlank(message = "Password cannot be blank")
	private String password;
	private String name;
	private String mobile;
	private String email;
	private Long currency;
	private Boolean terms;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Boolean getTerms() {
		return terms;
	}
	public void setTerms(Boolean terms) {
		this.terms = terms;
	}
	public Long getCurrency() {
		return currency;
	}
	public void setCurrency(Long currency) {
		this.currency = currency;
	}
}
