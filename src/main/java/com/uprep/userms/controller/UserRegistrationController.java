package com.uprep.userms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uprep.userms.reqpojo.LoginPojo;
import com.uprep.userms.reqpojo.RegisterPojo;
import com.uprep.userms.service.UserRegistrationService;

@RestController
@CrossOrigin("*")
@RequestMapping("/user")
public class UserRegistrationController {
	@Autowired
	private UserRegistrationService registrationService;

	@RequestMapping(value = "/register", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public ResponseEntity<?> registerUser(@ModelAttribute RegisterPojo pojo){
		return registrationService.registerUser(pojo);
	}
	@RequestMapping(value = "/login", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public ResponseEntity<?> loginUser(@ModelAttribute LoginPojo pojo){
		return registrationService.loginUser(pojo);
	}
}
