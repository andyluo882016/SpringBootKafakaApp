package com.example.demo.service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.example.demo.model.Item;

import org.springframework.beans.factory.annotation.Value;

@Service
public class Producer {

	private static final Logger logger = LoggerFactory.getLogger(Producer.class);
	private static final String TOPIC = "items";
	@Autowired
	private KafkaTemplate<String,Object> kafkaTemplate;
	
	public void sendMessage(Item item){
	logger.info(String.format("$$ -> Producing message --> %s",item));
	this.kafkaTemplate.send(TOPIC,item);
	}
}
