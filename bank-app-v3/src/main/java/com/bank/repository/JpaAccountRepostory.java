package com.bank.repository;

import javax.persistence.EntityManager;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bank.model.Account;

@Repository
public class JpaAccountRepostory implements AccountRepository {

	private static Logger logger = Logger.getLogger("bank");

	@Autowired 
	private EntityManager em;

	public JpaAccountRepostory() {
		logger.info("JpaAccountRepository instance created..");
	}

	public Account loadAccount(String num) {
		logger.info("loading account - " + num);
		return em.find(Account.class, num);
	}

	public void updateAccount(Account account) {
		logger.info("updating account - ");
		em.merge(account);
	}

}
