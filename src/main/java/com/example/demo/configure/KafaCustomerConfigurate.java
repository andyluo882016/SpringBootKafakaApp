package com.example.demo.configure;

import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;


import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;

import org.springframework.context.annotation.Bean;

import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.*;

import java.util.HashMap;
import java.util.Map;


@Configuration
@EnableKafka
public class KafaCustomerConfigurate {

	@Bean
	public ConsumerFactory<String, String> StrConsumerFactory() {
	     Map<String, Object> itemConfig =new HashMap<>();
	     
	     itemConfig.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
	     itemConfig.put(ConsumerConfig.GROUP_ID_CONFIG, "group-id");
	     itemConfig.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
	     itemConfig.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
	   
	      return new DefaultKafkaConsumerFactory<>(itemConfig);
	}
     @Bean
	 public ConcurrentKafkaListenerContainerFactory<String, String> kafkaListenerContainerFactory() {

	        ConcurrentKafkaListenerContainerFactory<String, String> itemfactory =new ConcurrentKafkaListenerContainerFactory<>();
	        itemfactory.setConsumerFactory(StrConsumerFactory());
	        return itemfactory;

	 }
}
