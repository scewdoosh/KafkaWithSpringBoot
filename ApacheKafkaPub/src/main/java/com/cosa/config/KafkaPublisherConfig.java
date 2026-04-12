package com.cosa.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JacksonJsonSerializer;

import com.cosa.model.Customer;
import com.cosa.util.ApplicationConstants;


@Configuration
public class KafkaPublisherConfig {
	
	@Bean
	public KafkaTemplate<String, Customer> kafkaTemplate()
	{
		return new KafkaTemplate<String, Customer>(producerFactory());
	}

	@Bean
	public ProducerFactory<String, Customer> producerFactory() {
		Map<String, Object> configProps = new HashMap<>();
		configProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, ApplicationConstants.HOST_URL);
		configProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		configProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,JacksonJsonSerializer.class);
		return new DefaultKafkaProducerFactory<>(configProps);
	}
	
}
