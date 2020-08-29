package com.uprep.userms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.uprep.userms.entity.User;
import com.uprep.userms.repository.UserRepository;


@Component
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		User user = userRepository.findByLoginId(username);
		if(user == null) new UsernameNotFoundException("User not found");
		return user;
	}

	public User loadUserById(Long userId) {
		User user = userRepository.findUserById(userId);
		if(user == null) new UsernameNotFoundException("User not found");
		return user;
	}
}
