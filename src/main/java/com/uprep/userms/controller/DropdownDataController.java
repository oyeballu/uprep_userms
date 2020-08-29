package com.uprep.userms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.uprep.userms.service.DropdownDataService;


@CrossOrigin("*")
@RestController
@RequestMapping("/user")
public class DropdownDataController {
	@Autowired
	private DropdownDataService dropdownDataService;

	@GetMapping("/fetchdropdown")
	public ResponseEntity<?> dropDownData(@RequestParam String lgn){
		return dropdownDataService.fetchDropdownList(lgn);
	}
	@GetMapping("/test")
	public ResponseEntity<?> test(){
		return new ResponseEntity<String>("done",HttpStatus.OK);
	}
}
