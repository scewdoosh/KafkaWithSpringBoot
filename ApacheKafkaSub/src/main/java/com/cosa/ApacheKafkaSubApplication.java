package com.cosa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;

import com.cosa.util.ApplicationConstants;

@SpringBootApplication
public class ApacheKafkaSubApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApacheKafkaSubApplication.class, args);
		
	}
	
	@KafkaListener(topics= ApplicationConstants.TOPIC_NAME, groupId = "group_cosa_matters")
	public void subscriberMsgFromKafkaTopic(String cxData) {
		System.out.println("msg frm kafka server/broker");
		System.out.println(cxData);
	}

}
