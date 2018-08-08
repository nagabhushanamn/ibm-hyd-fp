package com.bank.repository;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

import com.bank.model.Account;

@Repository
public class JpaAccountRepostory implements AccountRepository {


	private static Logger logger=Logger.getLogger("bank");
	
	public JpaAccountRepostory() {
		logger.info("JpaAccountRepository instance created..");
	}
	

	public Account loadAccount(String num) {
		logger.info("loading account - "+num);
		// ...
		return null;
	}

	public void updateAccount(Account account) {
		logger.info("updating account - ");
		// ..
	}


}
