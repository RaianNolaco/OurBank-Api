package com.OurBank.OurBankApi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class OurBankApiApplication {

	//metodo main da aplicação, na main que será startado todo o projeto
	public static void main(String[] args) {
		SpringApplication.run(OurBankApiApplication.class, args);
		// testando branch

	}

}
