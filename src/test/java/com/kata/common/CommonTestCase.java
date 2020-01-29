package com.kata.common;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.junit.Before;

import com.kata.App;
import com.kata.entity.Account;
import com.kata.entity.Transaction;
import com.kata.util.Constants;
/**
 * Common test case for the project
 * <br>
 * @author Kaissun
 *
 */
public class CommonTestCase {

	protected static Account myAccount = null;
	protected static Transaction withdrawTransaction100 = null;
	protected static Transaction withdrawTransaction1000 = null;
	protected static Transaction withdrawTransaction100000 = null;
	protected static Transaction depositTransaction100 = null;
	protected static Transaction depositTransaction1000 = null;
	protected static Transaction depositTransaction0 = null;

	@Before
	public void executedBeforeEach() {
		myAccount = new Account("Kais Ben Slama", "Kaissun01", 1000, 200);
		withdrawTransaction100 = new Transaction(Constants.WITHDRAW, 100, new Date(System.currentTimeMillis()));
		withdrawTransaction1000 = new Transaction(Constants.WITHDRAW, 1000, new Date(System.currentTimeMillis()));
		withdrawTransaction100000 = new Transaction(Constants.WITHDRAW, 100000, new Date(System.currentTimeMillis()));
		depositTransaction100 = new Transaction(Constants.DEPOSIT, 100, new Date(System.currentTimeMillis()));
		depositTransaction1000 = new Transaction(Constants.DEPOSIT, 1000, new Date(System.currentTimeMillis()));
		depositTransaction0 = new Transaction(Constants.DEPOSIT, 0, new Date(System.currentTimeMillis()));
	}
}
