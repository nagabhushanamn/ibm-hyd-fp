package com.bank;

import java.util.List;
import java.util.concurrent.atomic.DoubleAdder;

import com.bank.model.Txn;
import com.bank.util.Timer;

class TxnAnountAccumualtor {

	double total = 0;

	public void accept(Txn txn) {
		total += txn.getAmount(); // read + increment with new-salary + write
	}

	public synchronized void acceptSync(Txn txn) {
		total += txn.getAmount(); // read + increment with new-salary + write
	}

	// atomic class
	DoubleAdder doubleAdder = new DoubleAdder();

	public void acceptAtomic(Txn txn) {
		doubleAdder.add(txn.getAmount());
	}

}

public class App {

	public static void main(String[] args) {

		List<Txn> txns = Txn.randomlyGenerate(20_00_0000); // data-in

		//
		double total = 0.0; // data-out

		// ---------------------------------------------------------
		// Imperative Style
		// ---------------------------------------------------------

		System.out.println("statefull & sequential");
		total = Timer.timeIt(App::getTotal_1, txns);
		System.out.println(total);

		// ---------------------------------------------------------
		System.out.println("---------------------------------------------------------");
		// ---------------------------------------------------------

		System.out.println("statefull  & parallel  (no sync )");
		total = Timer.timeIt(App::getTotal_2, txns);
		System.out.println(total);

		// ---------------------------------------------------------
		System.out.println("---------------------------------------------------------");
		// ---------------------------------------------------------

		System.out.println("statefull  & parallel  ( sync )");
		total = Timer.timeIt(App::getTotal_3, txns);
		System.out.println(total);

		// ---------------------------------------------------------
		System.out.println("---------------------------------------------------------");
		// ---------------------------------------------------------

		System.out.println("statefull  & parallel  ( atomic util )");
		total = Timer.timeIt(App::getTotal_4, txns);
		System.out.println(total);

		
		System.out.println("=========================================================");
		
		// ---------------------------------------------------------
		// Declarative style or Functional Style
		// ---------------------------------------------------------
		
		
		System.out.println();
		//
		System.out.println("Staless & sequential ");
		total = Timer.timeIt(App::getTotal_5, txns);
		System.out.println(total);

		
		// ---------------------------------------------------------
			System.out.println("---------------------------------------------------------");
		// ---------------------------------------------------------

				
		System.out.println("Staless & parallel ");
		total = Timer.timeIt(App::getTotal_6, txns);
		System.out.println(total);

		
		
		
	}

	private static double getTotal_1(List<Txn> txns) {
		TxnAnountAccumualtor amountAcc = new TxnAnountAccumualtor();
		for (Txn txn : txns) {
			amountAcc.accept(txn);
		}
		return amountAcc.total;
	}

	private static double getTotal_2(List<Txn> txns) {
		TxnAnountAccumualtor amountAcc = new TxnAnountAccumualtor();
		txns.parallelStream().forEach(txn -> amountAcc.accept(txn));
		return amountAcc.total;
	}

	private static double getTotal_3(List<Txn> txns) {
		TxnAnountAccumualtor amountAcc = new TxnAnountAccumualtor();
		txns.parallelStream().forEach(txn -> amountAcc.acceptSync(txn));
		return amountAcc.total;
	}

	private static double getTotal_4(List<Txn> txns) {
		TxnAnountAccumualtor amountAcc = new TxnAnountAccumualtor();
		txns.parallelStream().forEach(txn -> amountAcc.acceptAtomic(txn));
		return amountAcc.doubleAdder.doubleValue();
	}
	
	private static double getTotal_5(List<Txn> txns) {
		return txns
		.stream()
		.mapToDouble(txn->txn.getAmount())
		.sum();
	}
	private static double getTotal_6(List<Txn> txns) {
		return txns
		.stream()
		.parallel()
		.mapToDouble(txn->txn.getAmount())
		.sum();
	}

}
