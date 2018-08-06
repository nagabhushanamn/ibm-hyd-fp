package com.bank;

import java.util.List;

import com.bank.model.Txn;
import com.bank.repository.AccountRepository;
import com.bank.repository.JdbcAccountRepository;
import com.bank.repository.JpaTxnRepository;
import com.bank.repository.TxnRepository;
import com.bank.service.TxnService;
import com.bank.service.TxnServiceIml;
import com.bank.service.TxrService;
import com.bank.service.TxrServiceImpl;

public class App {

	public static void main(String[] args) {

		// init

		AccountRepository accountRepository = new JdbcAccountRepository();
		TxrService txrService = new TxrServiceImpl(accountRepository);
		TxnRepository txnRepository=new JpaTxnRepository();
		TxnService txnService=new TxnServiceIml(txnRepository);

		// use
		//------------------------------------------------------------
		//txrService.txr(100, "1", "2");
		//System.out.println();
		//txrService.txr(200, "3", "4");
		//------------------------------------------------------------
		
		List<Txn> result=txnService.getTxns(3000);
		for(Txn txn:result) {
			System.out.println(txn);
		}
		

		// destroy
		// ..

	}

}
