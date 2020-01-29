package com.kata.entity;

import java.util.Date;

/**
 * the transaction that could be done by the costumer in the bank. Two types of transactions could be done:
 * Withdraw and deposit
 * 
 * @author Kaissun
 *
 */
public class Transaction {
	
	private String transactionType;
	private double amount;
	private Date dateOperation;
	private double balanceAfterTransaction;
	
	public Transaction(String transactionType, double amount, Date dateOperation) {
		this.transactionType = transactionType;
		this.amount = amount;
		this.dateOperation = dateOperation;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Date getDateOperation() {
		return dateOperation;
	}

	public void setDateOperation(Date dateOperation) {
		this.dateOperation = dateOperation;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public double getBalanceAfterTransaction() {
		return balanceAfterTransaction;
	}

	public void setBalanceAfterTransaction(double balanceAfterTransaction) {
		this.balanceAfterTransaction = balanceAfterTransaction;
	}
	
}
