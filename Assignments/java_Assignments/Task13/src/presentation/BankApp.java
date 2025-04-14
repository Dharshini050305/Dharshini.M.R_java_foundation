package presentation;

import entity.*;
import service.BankServiceProviderImpl;

import java.util.Scanner;
public class BankApp {
	 public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);
	        BankServiceProviderImpl bank = new BankServiceProviderImpl();
	        while (true) {
	            System.out.println("\n--- Bank Menu ---");
	            System.out.println("1. Create Account");
	            System.out.println("2. Deposit");
	            System.out.println("3. Withdraw");
	            System.out.println("4. Get Balance");
	            System.out.println("5. Transfer");
	            System.out.println("6. Get Account Details");
	            System.out.println("7. List Accounts");
	            System.out.println("8. Calculate Interest");
	            System.out.println("9. Exit");
	            System.out.print("Enter your choice: ");
	            int choice = sc.nextInt();
	            try {
	                switch (choice) {
	                    case 1:
	                        System.out.print("Enter Customer Name: ");
	                        String name = sc.next();
	                        System.out.print("Enter Age: ");
	                        int age = sc.nextInt();
	                        Customer c = new Customer();
	                        c.setName(name);
	                        c.setAge(age);
	                        System.out.println("Choose Account Type: Savings / Current / ZeroBalance");
	                        String accType = sc.next();
	                        System.out.print("Enter Initial Balance: ");
	                        float balance = sc.nextFloat();
	                        bank.create_account(c, accType, balance);
	                        System.out.println("Account Created Successfully.");
	                        break;
	                    case 2:
	                        System.out.print("Enter Account Number: ");
	                        long dAcc = sc.nextLong();
	                        System.out.print("Enter Deposit Amount: ");
	                        float dAmount = sc.nextFloat();
	                        float dBal = bank.deposit(dAcc, dAmount);
	                        System.out.println("Deposited. New Balance: " + dBal);
	                        break;
	                    case 3:
	                        System.out.print("Enter Account Number: ");
	                        long wAcc = sc.nextLong();
	                        System.out.print("Enter Withdrawal Amount: ");
	                        float wAmount = sc.nextFloat();
	                        float wBal = bank.withdraw(wAcc, wAmount);
	                        System.out.println("Withdrawn. New Balance: " + wBal);
	                        break;
	                    case 4:
	                        System.out.print("Enter Account Number: ");
	                        long bAcc = sc.nextLong();
	                        float bal = bank.get_account_balance(bAcc);
	                        System.out.println("Current Balance: " + bal);
	                        break;
	                    case 5:
	                        System.out.print("From Account: ");
	                        long from = sc.nextLong();
	                        System.out.print("To Account: ");
	                        long to = sc.nextLong();
	                        System.out.print("Enter Amount: ");
	                        float amt = sc.nextFloat();
	                        bank.transfer(from, to, amt);
	                        System.out.println("Transferred Successfully.");
	                        break;
	                    case 6:
	                        System.out.print("Enter Account Number: ");
	                        long accNo = sc.nextLong();
	                        bank.getAccountDetails(accNo);
	                        break;
	                    case 7:
	                        bank.listAccounts();
	                        break;
	                    case 8:
	                        bank.calculateInterest();
	                        System.out.println("Interest Calculated for all Savings Accounts.");
	                        break;
	                    case 9:
	                        System.out.println("Exiting... Thank you!");
	                        System.exit(0);
	                    default:
	                        System.out.println("Invalid choice. Try again.");
	                }
	            } catch (Exception e) {
	                System.out.println("Error: " + e.getMessage());
	            }
	        }
	 }

}
