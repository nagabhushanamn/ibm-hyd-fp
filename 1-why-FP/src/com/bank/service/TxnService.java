package com.bank.service;

import java.time.LocalDate;
import java.util.List;

import com.bank.model.Txn;

public interface TxnService {
	
	public  List<Txn> getTxns(double amount);
	public  List<Txn> getTxns(double minAmount,double maxAmount);
	public  List<Txn> getTxns(LocalDate date);
	public  List<Txn> getTxns(LocalDate from,LocalDate to);

}
