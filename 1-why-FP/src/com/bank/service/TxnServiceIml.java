package com.bank.service;

import java.time.LocalDate;
import java.util.List;

import org.apache.log4j.Logger;

import com.bank.model.Txn;
import com.bank.repository.TxnRepository;

public class TxnServiceIml implements TxnService {

	private static Logger logger = Logger.getLogger("bank");
	private TxnRepository txnRepository;

	public TxnServiceIml(TxnRepository txnRepository) {
		super();
		this.txnRepository = txnRepository;
		logger.info("TxnServiceIml instance created");

	}

	@Override
	public List<Txn> getTxns(double amount) {
		// TODO
		return null;
	}

	@Override
	public List<Txn> getTxns(double minAmount, double maxAmount) {
		// TODO
		return null;
	}

	@Override
	public List<Txn> getTxns(LocalDate date) {
		return null;
	}

	@Override
	public List<Txn> getTxns(LocalDate from, LocalDate to) {
		return null;
	}

}
