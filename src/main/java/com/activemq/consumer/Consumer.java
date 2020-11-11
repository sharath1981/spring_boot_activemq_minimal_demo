package com.activemq.consumer;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
@Component
public class Consumer {
	
	private final JmsTemplate jmsTemplate;

	//@JmsListener(destination = "inmemory.queue")
	private void listener(final String message) {
		log.info("RECEIVED==>{}", message);
	}
	
}
