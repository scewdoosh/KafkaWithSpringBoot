package com.cosa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.cosa.model.Customer;
import com.cosa.util.ApplicationConstants;

@Service
public class KafkaService {
	
	@Autowired
	private KafkaTemplate<String, Customer> kafkaTemp;
	
	public String addCustomerMsg(Customer cx){
		kafkaTemp.send(ApplicationConstants.TOPIC_NAME,cx);
		return "Customer Data Added into Kafka Server";
	}
}
