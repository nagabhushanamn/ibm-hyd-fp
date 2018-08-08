package com.bank;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.bank.service.TxrService;

@SpringBootApplication
public class BankAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankAppApplication.class, args);
	}
	
//	@Bean
//	public CommandLineRunner test(TxrService txrService) {
//		return args->{
//			txrService.txr(500.00, "1", "2");
//		};
//	}
}
