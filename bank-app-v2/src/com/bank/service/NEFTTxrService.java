package com.bank.service;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.model.Account;
import com.bank.repository.AccountRepository;
import com.bank.repository.JpaAccountRepostory;

/*
 *  performance & design issues
 *  -------------------------------
 *  
 *  
 *  1. too many duplicate dependency instances are being created
 *     -> slow,memory,resource consumption is high
 *  2. tight-coupling
 *     -> can't extend component with new-features 
 *  3. unit-testing not possible
 *     -> bug/dev slow
 * 
 * 
 *   why these issues ?
 *   
 *    ==> dependent itself creating its own dependency
 *    
 *    soln :
 *    
 *    ==> dont create , do lookup on factory
 *    
 *    limitation on factory-lookup :
 *    
 *    ==> factory-location tight-coupling
 *    
 *    best-soln:
 *    
 *    ==> dont create/lookup  , inject by 'third-party'  ( IOC )
 *    
 *        how to to implement IOC ?
 *        
 *        ==> by dependency injection ( di )
 *        
 *        
 *        
 *        
 * 
 * 
 */

@Service
public class NEFTTxrService implements TxrService {

	private static Logger logger = Logger.getLogger("bank");

	private AccountRepository accountRepository;

	@Autowired
	public NEFTTxrService(AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
		logger.info("TxrService instance created..");
	}

	@Override
	public void txr(double amount, String fromAccNum, String toAccNum) {

		logger.info("txr initiatited");
		// JpaAccountRepostory jpaAccountRepostory = new JpaAccountRepostory();

		Account fromAccount = accountRepository.loadAccount(fromAccNum);
		Account toAccount = accountRepository.loadAccount(toAccNum);

		// debit & credit

		accountRepository.updateAccount(fromAccount);
		accountRepository.updateAccount(toAccount);

		logger.info("txr finished");
	}

}
