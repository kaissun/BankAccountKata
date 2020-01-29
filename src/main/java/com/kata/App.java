package com.kata;

import java.text.NumberFormat;
import java.util.Date;
import java.util.Scanner;

import com.kata.entity.Account;
import com.kata.entity.Transaction;
import com.kata.util.Constants;

/**
 * Bank Account Kata - OLBATI
 * 
 * @author Kaissun - kais.benslama@gmail.com
 * 
 * @version 1.0
 *
 */
public class App {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int userChoice;
		boolean quit = false;
		Account myAccount = null;
		// We suppose that the currency used is EURO based on operating system
		// We defined as initial amount as 1000euros and maximum borrowing in the account is 200euros (RED)
		//TODO We could add a new properties file that will contain the values by default as the name, the ID, the initial amount and max borrow
		myAccount = new Account("Kais Ben Slama", "Kaissun01", 1000, 200);
		System.out.printf("================Welcome To KATA================\n");
		System.out.printf("Connected Account Name|Id : " + myAccount.getAccountName() + "|"
				+ myAccount.getAccountId() + " \n          Initial balance : " + NumberFormat.getCurrencyInstance().format(myAccount.getBalance()) + "\n"
				+ "        Maximum Borrowing : " + NumberFormat.getCurrencyInstance().format(myAccount.getMaximumBorrowing()) + "\n");
		do {
			System.out.printf("\n=======================================\n");
			System.out.println("    	    1. Deposit money");
			System.out.println("    	    2. Withdraw money");
			System.out.println("    	    3. History of My Operations");
			System.out.println("    	    0. to quit ");
			System.out.printf("=======================================\n");
			userChoice = in.nextInt();
			
			switch (userChoice) {
			case 1:
				//____________________________USER STORY 1
				float amount;
				System.out.print("Amount to deposit: ");
				amount = in.nextFloat();
				myAccount.deposit(new Transaction(Constants.DEPOSIT, amount, new Date(System.currentTimeMillis())));
				break;

			case 2:
				//____________________________USER STORY 2
				System.out.print("Amount to withdraw: ");
				amount = in.nextFloat();
				myAccount.withdraw(new Transaction(Constants.WITHDRAW, amount, new Date(System.currentTimeMillis())));
				break;
			case 3:
				//____________________________USER STORY 3
				myAccount.printHistory();
				break;

			case 0:
				quit = true;
				break;
			default:
				System.out.println("Wrong choice. Please retry !");
				break;
			}

		} while (!quit);
		//TODO We could enhance our solution by saving the history of transactions in a text file
		System.out.println("Thank you !! See you later");
	}
}