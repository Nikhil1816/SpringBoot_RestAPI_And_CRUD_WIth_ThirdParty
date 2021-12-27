package com.customer.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication(scanBasePackages= {"com.customer.demo"})
public class Demo7RestTemplate1Application {

	
	public static void main(String[] args) throws Exception {
		SpringApplication.run(Demo7RestTemplate1Application.class, args);
	}

}
