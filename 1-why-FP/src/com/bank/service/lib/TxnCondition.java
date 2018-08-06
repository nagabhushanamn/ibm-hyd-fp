package com.bank.service.lib;

import com.bank.model.Txn;


public interface TxnCondition {
	boolean test(Txn txn);
}
