package com.example.demo.service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.example.demo.model.Item;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.concurrent.CountDownLatch;


@Service
public class Consumer {

	private final Logger logger = LoggerFactory.getLogger(Consumer.class);
	@KafkaListener(topics = "items", groupId = "group-id", containerFactory = "kafkaListenerContainerFactory")
	public void consume(String item) throws JsonParseException, JsonMappingException, IOException{
		System.out.println("\n--->>>>>  "+item);
	ObjectMapper mapper = new ObjectMapper();
	//Item[] cjson= mapper.readValue(item, Item[].class);
	//System.out.println("\n*****************---->>>> "+cjson.length);
	logger.info(String.format("$$ -> Consumed Message -> %s",item));
	item="";
	}
}
