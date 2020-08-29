package com.uprep.userms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.uprep.userms.entity.Currency;
import com.uprep.userms.repository.CurrencyRepository;

@Service
public class DropdownDataService {
	@Autowired 
	private CurrencyRepository currencyRepository;

	public ResponseEntity<?> fetchDropdownList(String lgn) {
		try {
			List<Currency> currencyList = currencyRepository.findAll();
			return new ResponseEntity<List<Currency>>(currencyList,HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<String>("Something went wrong!",HttpStatus.FORBIDDEN);
		}
	}

}
