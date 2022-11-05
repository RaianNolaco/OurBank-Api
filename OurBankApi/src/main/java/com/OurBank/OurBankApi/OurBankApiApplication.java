package com.OurBank.OurBankApi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class OurBankApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(OurBankApiApplication.class, args);
		System.out.println("hello");	
	}

}
