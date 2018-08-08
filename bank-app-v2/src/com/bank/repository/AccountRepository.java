package com.bank.repository;

import com.bank.model.Account;

public interface AccountRepository {

	Account loadAccount(String accNum);
	void updateAccount(Account account);
	
}
