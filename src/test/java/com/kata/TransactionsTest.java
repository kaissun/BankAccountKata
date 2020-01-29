package com.kata;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.kata.common.CommonTestCase;
/**
 * 
 * <li>Test withdraw : 100, 1000 and then 100000 (total transactions in the history should be 2)</li> 
 * <li>Test Deposit: 100, 1000 and then 0 (total transactions in the history should be 2)</li>
 * <li>Test this scenario: deposit 100, withdraw 1000, deposit 1000 and then withdraw 100 
 * (total transactions in the history should be 4)</li>
 * <br>
 * @author Kaissun
 *
 */
public class TransactionsTest extends CommonTestCase {

	@Test
	public void testTransactionsWithdraw() {
		myAccount.withdraw(withdrawTransaction100);
		assertEquals(900, myAccount.getBalance(), 0.00001);
		myAccount.withdraw(withdrawTransaction1000);
		assertEquals(-100, myAccount.getBalance(), 0.00001);
		myAccount.withdraw(withdrawTransaction100000);
		assertEquals(-100, myAccount.getBalance(), 0.00001);
		// Check the number of records inserted in the history of transactions
		assertEquals(2, myAccount.getTransactionHistory().size());
	}
	
	@Test
	public void testTransactionsDeposit() {
		myAccount.deposit(depositTransaction100);
		assertEquals(1100, myAccount.getBalance(), 0.00001);
		myAccount.deposit(depositTransaction1000);
		assertEquals(2100, myAccount.getBalance(), 0.00001);
		myAccount.deposit(depositTransaction0);
		assertEquals(2100, myAccount.getBalance(), 0.00001);
		// Check the number of records inserted in the history of transactions
		assertEquals(2, myAccount.getTransactionHistory().size());
	}
	
	@Test
	public void testTransactionsWithdrawAndDeposit() {
		myAccount.deposit(depositTransaction100);
		assertEquals(1100, myAccount.getBalance(), 0.00001);
		myAccount.withdraw(withdrawTransaction1000);
		assertEquals(100, myAccount.getBalance(), 0.00001);
		myAccount.deposit(depositTransaction1000);
		assertEquals(1100, myAccount.getBalance(), 0.00001);
		myAccount.withdraw(withdrawTransaction100);
		assertEquals(1000, myAccount.getBalance(), 0.00001);
		// Check the number of records inserted in the history of transactions
		assertEquals(4, myAccount.getTransactionHistory().size());
	}
	
	

}