package com.bank;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bank.config.BankConfig;
import com.bank.repository.AccountRepository;
import com.bank.repository.JpaAccountRepostory;
import com.bank.service.NEFTTxrService;
import com.bank.service.TxrService;

public class App {

	public static void main(String[] args) {

		// Init
		System.out.println("------------------------------------------");
		ConfigurableApplicationContext context = null;
		//context = new ClassPathXmlApplicationContext("bank.xml");
		context=new AnnotationConfigApplicationContext(BankConfig.class);
		System.out.println("------------------------------------------");
		// use
		TxrService txrService = context.getBean(TxrService.class);
		System.out.println();
		System.out.println("------------------------------------------");
		txrService.txr(100, "1", "2");
		System.out.println();
		txrService.txr(200, "3", "4");
		System.out.println("------------------------------------------");
		System.out.println();

		// destroy
		System.out.println("------------------------------------------");
		context.close();
		System.out.println("------------------------------------------");

	}

}
