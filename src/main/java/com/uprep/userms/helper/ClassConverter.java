package com.uprep.userms.helper;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.uprep.userms.entity.Currency;
import com.uprep.userms.entity.User;
import com.uprep.userms.repository.CurrencyRepository;
import com.uprep.userms.reqpojo.RegisterPojo;

@Component
public class ClassConverter {

	@Autowired
	private CurrencyRepository currencyRepository;
	
	public User registerPojoToUserEntity(RegisterPojo pojo) {
		Currency currency = currencyRepository.findCurrencyById(pojo.getCurrency());
		User user = new User(pojo.getLogin_id(), pojo.getPassword(), "active", pojo.getEmail(), new Date(),
				pojo.getName(),0, currency);
		return user;
	}

}
