package com.bank.service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.bank.model.Txn;
import com.bank.repository.TxnRepository;
import com.bank.service.lib.TxnCondition;
import com.bank.service.lib.TxnUtilLib;

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

		// imperative style ( what + How )

		List<Txn> in = txnRepository.findAll(); // input
//
//		List<Txn> out = new ArrayList<Txn>();
//		for (Txn txn : in) {
//			if (txn.getAmount() == amount) {
//				out.add(txn);
//			}
//		}

		//what
		
//		class TxnAmountCondition implements TxnCondition {
//			@Override
//			public boolean test(Txn txn) {
//				return txn.getAmount() == amount;
//			}
//		}
//		TxnCondition txnCondition=new TxnAmountCondition();
		
		// or
		
//		TxnCondition txnCondition=new TxnCondition() {
//			@Override
//			public boolean test(Txn txn) {
//				return txn.getAmount()==amount;
//			}
//		};
		
		// or   with FP
		TxnCondition txnCondition=txn-> txn.getAmount()==amount; 
		return TxnUtilLib.filter(in, txnCondition);

	}

	@Override
	public List<Txn> getTxns(double minAmount, double maxAmount) {
		// TODO
		List<Txn> in = txnRepository.findAll(); // input

//		List<Txn> out = new ArrayList<Txn>();
//		for (Txn txn : in) {
//			double amount = txn.getAmount();
//			if (amount >= minAmount && amount <= maxAmount) {
//				out.add(txn);
//			}
//		}

		
		return TxnUtilLib.filter(in, txn->txn.getAmount()>=minAmount && txn.getAmount()<=maxAmount);
	}

	@Override
	public List<Txn> getTxns(LocalDate date) {
		// TODO
		List<Txn> in = txnRepository.findAll(); // input

//		List<Txn> out = new ArrayList<Txn>();
//		for (Txn txn : in) {
//			double amount = txn.getAmount();
////			if () {
////				out.add(txn);
////			}
//		}

		return TxnUtilLib.filter(in, txn->txn.getLocalDateTime().toLocalDate().equals(date));
	}

	@Override
	public List<Txn> getTxns(LocalDate from, LocalDate to) {
		// TODO
		List<Txn> in = txnRepository.findAll(); // input

		List<Txn> out = new ArrayList<Txn>();
		for (Txn txn : in) {
			double amount = txn.getAmount();
//			if () {
//				out.add(txn);
//			}
		}

		return out;
	}

}
