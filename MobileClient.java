package com.del.client;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.del.exception.MobileException;
import com.del.service.MobileService;
import com.del.service.MobileServiceImpl;

public class MobileClient {
	private MobileService mService;

	public MobileClient() {
		mService = new MobileServiceImpl();
		Scanner scan = new Scanner(System.in);
		int choice = 0;
		System.out.println("Welcome to Mobile System");
		System.out.println("Enter login");
		String login = scan.nextLine();
		System.out.println("Enter password");
		String password = scan.nextLine();
		boolean loginSuccess = mService.authenticate(login, password);
		if (loginSuccess) {
			while (true) {
				choice = getChoice(scan);
				switch (choice) {
				case 1:
					System.out.println("DEPOSIT BILL AMOUNT AND MODE OF PAYMENT");
					System.out.println("Enter mode of payment");
					String mode=scan.nextLine();
					System.out.println("Enter Amount to be deposited");
					double amount = 0;
					try {
						amount = scan.nextDouble();
						mService.depositAmount(amount,mode);
					} catch (MobileException e) {
						System.err.println(e.getMessage());
					} catch (InputMismatchException e) {
						System.err.println("Enter number only");
						scan.nextLine(); 
					}
					break;
				case 2:
					System.out.println("CHECK UNPAID BALANCE");
					double balance = mService.getBalance();
					System.out.println("Balance: " + balance);
					break;
				case 3:
					System.out.println("Exiting... Thank you.");
					System.exit(0);
					break;
				default:
					System.out.println("Enter the correct choice");
					break;
				}
			}
		}
		else {
			System.out.println("Either login or password is wrong");
		}
	}

	private int getChoice(Scanner scan) {
		int choice = 0;
		System.out.println("MOBILE PAYMENT SYSTEM");
		System.out.println("1. Deposit amount");
		System.out.println("2. Check balance");
		System.out.println("3. Quit program");
		System.out.println("Enter a choice 1 to 3");
		try {
			choice = scan.nextInt();
		} catch (InputMismatchException e) {
			System.err.println("Please enter numbers only");
			scan.nextLine();
		}
		return choice;
	}

	public static void main(String[] args) {
		new MobileClient();
	}
}
