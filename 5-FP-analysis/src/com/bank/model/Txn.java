package com.bank.model;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

	public static List<Txn> randomlyGenerate(long limit) {

		Random random = new Random();
		return Stream.generate(() -> {
			int n = random.nextInt(1000);
			if (n < 0)
				n = -(n);
			return new Txn(n, n * 10, LocalDateTime.of(2017, 05, 13, 12, 30), TxnType.CREDT);
		}).limit(limit).collect(Collectors.toList());

	}

}
