package com.kata.entity;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.stream.Collectors;

/**
 * The bank Account defined for a unique costumer characterized by its name and ID.
 * We could deposit, withdraw if the maximumBorrowing value is not reached, or even printing the 
 * history of transactions.
 * 
 * @author Kaissun
 *
 */
public class Account {
	
	private String accountName;
	private String accountId;
	private double balance;
	private double maximumBorrowing;
	ArrayList<Transaction> transactionHistory = new ArrayList<>();

	StringBuilder sb = new StringBuilder();
	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
	
	public Account(String accountName, String accountId, double balance, double maximumBorrowing) {
		this.accountName = accountName;
		this.accountId = accountId;
		this.balance = balance;
		this.maximumBorrowing = maximumBorrowing;
	}

	/**
	 * Deposit an amount. It is a transaction as an input parameter.
	 * @param t
	 */
	public void deposit(Transaction t) {
		// No need to complete if the user puts ZERO value
		if (t.getAmount() == 0) {
			System.out.println("nothing deposited ..");
		} else {
			balance += t.getAmount();
			t.setBalanceAfterTransaction(balance);
			transactionHistory.add(t);
		}
	}

	/**
	 * Withdraw an amount. It is a transaction as an input parameter.
	 * We will not withdraw if the maximum borrowing is reached
	 * @param t
	 */
	public void withdraw(Transaction t) {
		// No need to complete if the user puts ZERO value
		if (t.getAmount() == 0) {
			System.out.println("nothing withdrawn ..");
		} else {
			if (t.getAmount() - balance > maximumBorrowing) {
				System.out.println("You cannot withdraw, total borrowing is reached !!");
			} else {
				balance -= t.getAmount();
				t.setBalanceAfterTransaction(balance);
				transactionHistory.add(t);
			}
		}
	}

	/**
	 * Print history of transactions. As we have in the bank account the newest transactions shoud be shown first. 
	 * So we need to inverse them before printing. 
	 */
	public void printHistory() {
		System.out.println("    OP     |     Date with time   |         Amount       |         Balance");
		transactionHistory.stream()
		.collect(Collectors.toCollection(LinkedList::new))
		.descendingIterator()
		.forEachRemaining(t -> System.out.printf("%-10s | %20s | %20s | %20s\n", t.getTransactionType(),
						sdf.format(t.getDateOperation()), NumberFormat.getCurrencyInstance().format(t.getAmount()), 
						NumberFormat.getCurrencyInstance().format(t.getBalanceAfterTransaction())));
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public double getMaximumBorrowing() {
		return maximumBorrowing;
	}
	
	public ArrayList<Transaction> getTransactionHistory() {
		return transactionHistory;
	}
}
