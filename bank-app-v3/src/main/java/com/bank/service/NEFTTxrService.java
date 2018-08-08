package com.bank.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bank.model.Account;
import com.bank.repository.AccountRepository;
import com.bank.repository.JpaAccountRepostory;

@Service
public class NEFTTxrService implements TxrService {

	private static Logger logger = Logger.getLogger("bank");

	private AccountRepository accountRepository;

	@Autowired
	public NEFTTxrService(AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
		logger.info("TxrService instance created..");
	}

	@Transactional
	@Override
	public void txr(double amount, String fromAccNum, String toAccNum) {

		logger.info("txr initiatited");
		// JpaAccountRepostory jpaAccountRepostory = new JpaAccountRepostory();

		Account fromAccount = accountRepository.loadAccount(fromAccNum);
		Account toAccount = accountRepository.loadAccount(toAccNum);

		// debit & credit
		fromAccount.setBalance(fromAccount.getBalance() - amount);
		toAccount.setBalance(toAccount.getBalance() + amount);

		accountRepository.updateAccount(fromAccount);
		accountRepository.updateAccount(toAccount);

		logger.info("txr finished");
	}

}
