package com.activemq.controller;

import java.util.stream.IntStream;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1")
public class HelloController {

	private final JmsTemplate jmsTemplate;
	
	@GetMapping("hello/{message}")
	public String hello(@PathVariable("message") String message) {
		IntStream.range(1, 5)
		         .mapToObj(i->message+i)
		         .forEach(msg-> {
		        	 jmsTemplate.convertAndSend("inmemory.queue", msg);
		        	 log.info("PUBLISHED==>{}", msg);
		         });
		return "PUBLISHED";
	}
	
	@GetMapping("receive")
	public String receive() {
		return (String)jmsTemplate.receiveAndConvert("inmemory.queue");
	}


}
