package entity;

import java.util.Scanner;

public class Bank {
	 public static void main(String[] args) {
	      
  
	            Scanner sc = new Scanner(System.in);

	            // Create Customer
	            System.out.println("Enter Customer Details:");
	            System.out.print("Customer ID: ");
	            int custId = sc.nextInt(); sc.nextLine();
	            System.out.print("First Name: ");
	            String fName = sc.nextLine();
	            System.out.print("Last Name: ");
	            String lName = sc.nextLine();
	            System.out.print("Email: ");
	            String email = sc.nextLine();
	            System.out.print("Phone Number: ");
	            String phone = sc.nextLine();
	            System.out.print("Address: ");
	            String address = sc.nextLine();

	            Customer customer = new Customer(custId, fName, lName, email, phone, address);

	            // Create Account
	            System.out.println("\nEnter Account Details:");
	            System.out.print("Account Number: ");
	            int accNumber = sc.nextInt(); sc.nextLine();
	            System.out.print("Account Type (Savings/Current): ");
	            String accType = sc.nextLine();
	            System.out.print("Initial Balance: ");
	            double balance = sc.nextDouble();

	            Account account = new Account(accNumber, accType, balance);

	            boolean running = true;

	            while (running) {
	                System.out.println("\n--- BANK MENU ---");
	                System.out.println("1. Deposit");
	                System.out.println("2. Withdraw");
	                System.out.println("3. Calculate Interest");
	                System.out.println("4. View Customer Info");
	                System.out.println("5. View Account Info");
	                System.out.println("6. Exit");
	                System.out.print("Choose an option: ");
	                int choice = sc.nextInt();

	                switch (choice) {
	                    case 1:
	                        System.out.print("Enter deposit amount: ");
	                        double deposit = sc.nextDouble();
	                        account.deposit(deposit);
	                        break;
	                    case 2:
	                        System.out.print("Enter withdrawal amount: ");
	                        double withdraw = sc.nextDouble();
	                        account.withdraw(withdraw);
	                        break;
	                    case 3:
	                        account.calculateInterest();
	                        break;
	                    case 4:
	                        customer.printCustomerInfo();
	                        break;
	                    case 5:
	                        account.printAccountInfo();
	                        break;
	                    case 6:
	                        running = false;
	                        System.out.println("Thank you for using the bank system.");
	                        break;
	                    default:
	                        System.out.println("Invalid option. Please try again.");
	                }
	            }

	            sc.close();
	        }
	    }
