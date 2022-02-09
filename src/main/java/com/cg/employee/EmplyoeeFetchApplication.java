package com.cg.employee;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableAutoConfiguration
@EnableScheduling
@ComponentScan(basePackages = {"com.cg.employee"})
public class EmplyoeeFetchApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmplyoeeFetchApplication.class, args);
	}
	
	 @Bean
	    public RestTemplate restTemplate(RestTemplateBuilder builder) {
	         return builder.build();
	    }	
	

}
