package com.bank.service.lib;

import java.util.ArrayList;
import java.util.List;

import com.bank.model.Txn;

public class TxnUtilLib {

	public static List<Txn> filter(List<Txn> in,TxnCondition txnCondition) {
		List<Txn> out = new ArrayList<Txn>();
		for (Txn txn : in) {
			if(txnCondition.test(txn))
				out.add(txn);
		}
		return out;
	}

}
