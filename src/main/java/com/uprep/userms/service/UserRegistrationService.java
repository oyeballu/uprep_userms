package com.uprep.userms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.uprep.userms.entity.User;
import com.uprep.userms.helper.ClassConverter;
import com.uprep.userms.repository.UserRepository;
import com.uprep.userms.reqpojo.LoginPojo;
import com.uprep.userms.reqpojo.RegisterPojo;

@Service
public class UserRegistrationService {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private ClassConverter converterObj;

	public ResponseEntity<?> registerUser(RegisterPojo pojo) {
		try {
			User userObj = converterObj.registerPojoToUserEntity(pojo);
			userRepository.save(userObj);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>("Enable to register user!", HttpStatus.FORBIDDEN);
		}
		return new ResponseEntity<String>("User Successfully Registered!", HttpStatus.ACCEPTED);
	}

	public ResponseEntity<?> loginUser(LoginPojo pojo) {
		try {
			User user = userRepository.findByLoginIdAndPassword(pojo.getLogin_id(),pojo.getPassword());
			return new ResponseEntity<User>(user,HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>("Not Registered!",HttpStatus.UNAUTHORIZED);
		}
	}
}
