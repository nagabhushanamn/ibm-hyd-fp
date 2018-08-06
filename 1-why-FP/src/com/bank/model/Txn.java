package com.bank.model;

import java.time.LocalDateTime;

public class Txn {

	private int id;
	private double amount;
	private LocalDateTime localDateTime;
	private TxnType type;

	public Txn(int id, double amount, LocalDateTime localDateTime, TxnType type) {
		super();
		this.id = id;
		this.amount = amount;
		this.localDateTime = localDateTime;
		this.type = type;
	}

	public int getId() {
		return id;
	}

	public double getAmount() {
		return amount;
	}

	public LocalDateTime getLocalDateTime() {
		return localDateTime;
	}

	public TxnType getType() {
		return type;
	}

	@Override
	public String toString() {
		return "Txn [id=" + id + ", amount=" + amount + ", localDateTime=" + localDateTime + ", type=" + type + "]";
	}
	
	

}
