package com.cosa.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cosa.model.Customer;
import com.cosa.service.KafkaService;

@RestController
public class CustomerController {
	@Autowired
	private KafkaService service;
	
	@PostMapping("/add-cx")
	public String addCx(@RequestBody Customer c) {
		return service.addCustomerMsg(c);
	}
	
}
