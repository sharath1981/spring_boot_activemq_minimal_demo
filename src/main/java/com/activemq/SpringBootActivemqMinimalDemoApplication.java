package com.activemq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;

@EnableJms
@SpringBootApplication
public class SpringBootActivemqMinimalDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootActivemqMinimalDemoApplication.class, args);
	}

}
