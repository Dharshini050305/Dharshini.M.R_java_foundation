package nestedconditionalstatements;

import java.util.Scanner;

public class Transactions {

	public static void main(String[] args) {
	
		 Scanner sc = new Scanner(System.in);
	        System.out.print("Enter your current balance: ");
	        double balance = sc.nextDouble();

	        // Display menu
	        System.out.println("1. Check Balance");
	        System.out.println("2. Withdraw");
	        System.out.println("3. Deposit");
	        System.out.print("Enter your choice: ");

	        // Get user choice
	        int choice = sc.nextInt();

	        switch (choice) {
	            case 1: // Check Balance
	                System.out.println("Your current balance is: " + balance);
	                break;

	            case 2: // Withdraw
	                System.out.print("Enter amount to withdraw: ");
	                double withdrawAmount = sc.nextDouble();

	                if (withdrawAmount > balance) {
	                    System.out.println("Insufficient balance.");
	                } else if (withdrawAmount % 100 != 0 && withdrawAmount % 500 != 0) {
	                    System.out.println("Withdrawal amount must be in multiples of 100 or 500.");
	                } else {
	                    balance -= withdrawAmount;
	                    System.out.println("Withdrawal successful. Remaining balance: " + balance);
	                }
	                break;

	            case 3: // Deposit
	                System.out.print("Enter amount to deposit: ");
	                double depositAmount = sc.nextDouble();

	                if (depositAmount <= 0) {
	                    System.out.println("Invalid deposit amount.");
	                } else {
	                    balance += depositAmount;
	                    System.out.println("Deposit successful. New balance: " + balance);
	                }
	                break;

	            default:
	                System.out.println("Invalid choice");
	        }

	}

}
