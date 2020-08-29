package com.uprep.userms.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String login_id;
	@JsonIgnore
	private String password;
	@JsonIgnore
	private String password1;
	@JsonIgnore
	private String password2;
	private String status;
	private String mail;
	private Date creation_date;
	private Date expiry_date;
	private String full_name;
	private String notificationid;
	private String tokenid;
	private int optout;
	@OneToOne
	@JoinColumn(name="currency",referencedColumnName="id")
	private Currency currency;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
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
	public String getPassword1() {
		return password1;
	}
	public void setPassword1(String password1) {
		this.password1 = password1;
	}
	public String getPassword2() {
		return password2;
	}
	public void setPassword2(String password2) {
		this.password2 = password2;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getCreation_date() {
		return creation_date;
	}
	public void setCreation_date(Date creation_date) {
		this.creation_date = creation_date;
	}
	public Date getExpiry_date() {
		return expiry_date;
	}
	public void setExpiry_date(Date expiry_date) {
		this.expiry_date = expiry_date;
	}
	public String getFull_name() {
		return full_name;
	}
	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}
	public String getNotificationid() {
		return notificationid;
	}
	public void setNotificationid(String notificationid) {
		this.notificationid = notificationid;
	}
	public String getTokenid() {
		return tokenid;
	}
	public void setTokenid(String tokenid) {
		this.tokenid = tokenid;
	}
	public int getOptout() {
		return optout;
	}
	public void setOptout(int optout) {
		this.optout = optout;
	}
	public Currency getCurrency() {
		return currency;
	}
	public void setCurrency(Currency currency) {
		this.currency = currency;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public User(String login_id, String password, String status, String mail, Date creation_date,
			String full_name, int optout, Currency currency) {
		super();
		this.login_id = login_id;
		this.password = password;
		this.status = status;
		this.mail = mail;
		this.creation_date = creation_date;
		this.full_name = full_name;
		this.optout = optout;
		this.currency = currency;
	}
}
