package com.example.demo.controller;
import com.example.demo.service.Producer;
import java.util.*;
import com.example.demo.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping(value = "/kafka")
public class HomeController {
	 @Autowired
        private KafkaTemplate<String, Object> mykafka;
        
        private static final String topic="items";

        private final Producer producer;
	
	@Autowired
	public HomeController(Producer producer) {
	this.producer = producer;
	}
	

	@PostMapping(value = "/publish")
	public void sendMessageToKafkaTopic(@RequestParam("items") String items){
		Item item= new Item(8880, items, "Book");
		producer.sendMessage(item);
	}
	@GetMapping("/show")
	public String show() {
		return "Hello Testing";
	}
	//int id, String name, String category
	@GetMapping("/getone")
	public String showOne() {
		//Optional<Item> cust =customerRepository.findById(id);
		Item item= new Item(12890, "Java Programming", "Book");
		System.out.println("*********  --> "+ item.toString());
		producer.sendMessage(item);
		return "The Customer has been send";
	}
	
	 @GetMapping("/getalls/{id}/{name}")
		public List<Item> showOne(@PathVariable("id") Integer id, @PathVariable("name") String name) {
		 Item item= new Item(12890, "Java Programming", "Book");
		 Item item2= new Item(id, name, "Bike");
		 List<Item> list=new LinkedList<>();
			list.add(item);
			list.add(item2);
			mykafka.send(topic,list);
			return list;
		}
}
