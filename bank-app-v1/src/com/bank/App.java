package com.bank;

import com.bank.repository.AccountRepository;
import com.bank.repository.JpaAccountRepostory;
import com.bank.service.NEFTTxrService;
import com.bank.service.TxrService;

public class App {

	public static void main(String[] args) {

		// Init
		System.out.println("------------------------------------------");
		AccountRepository accountRepository = new JpaAccountRepostory();
		TxrService txrService = new NEFTTxrService(accountRepository);
		System.out.println("------------------------------------------");
		// use
		System.out.println();
		System.out.println("------------------------------------------");
		txrService.txr(100, "1", "2");
		txrService.txr(200, "3", "4");
		System.out.println("------------------------------------------");
		System.out.println();

		// destroy
		System.out.println("------------------------------------------");
		System.out.println("------------------------------------------");

	}

}
