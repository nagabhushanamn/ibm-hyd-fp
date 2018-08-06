package com.bank.repository;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.apache.log4j.Logger;

import com.bank.model.Txn;
import com.bank.model.TxnType;

public class JpaTxnRepository implements TxnRepository {

	private static Logger logger = Logger.getLogger("bank");

	public JpaTxnRepository() {
		logger.info("JpaTxnRepository instance created");
	}

	@Override
	public List<Txn> findAll() {
		List<Txn> txns = Arrays.asList(new Txn(234234, 2000, LocalDateTime.of(2017, 05, 13, 12, 30), TxnType.DEBIT),
				new Txn(453453, 2000, LocalDateTime.of(2017, 05, 13, 12, 30), TxnType.DEBIT),
				new Txn(345345, 3000, LocalDateTime.of(2018, 04, 23, 10, 30), TxnType.CREDT),
				new Txn(456456, 1000, LocalDateTime.of(2018, 03, 23, 13, 50), TxnType.DEBIT),
				new Txn(242344, 6000, LocalDateTime.of(2018, 02, 24, 14, 30), TxnType.DEBIT),
				new Txn(345345, 7000, LocalDateTime.of(2018, 03, 15, 20, 20), TxnType.CREDT),
				new Txn(678786, 5000, LocalDateTime.of(2018, 01, 25, 16, 10), TxnType.DEBIT),
				new Txn(865867, 3000, LocalDateTime.of(2018, 06, 13, 18, 10), TxnType.CREDT));

		return txns;
	}

}
