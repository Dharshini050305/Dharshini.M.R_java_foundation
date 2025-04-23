package presentation;

import entity.*;
import exception.InsufficientFundException;
import exception.InvalidAccountException;
import exception.OverDraftLimitExceededException;
import service.BankServiceProviderImpl;
import service.IBankServiceProvider;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
public class BankApp {
	 private static String lastname;
	private static String firstname;
	private static int customerid;
	private static long phonenumber;
	private static long accountid;

	public static void main(String[] args) throws Exception {
	        IBankServiceProvider bankServiceProvider = new BankServiceProviderImpl();
	        Scanner scanner = new Scanner(System.in);

	        int choice;
	        do {
	            System.out.println("<------ Banking System Menu ------>");
	            System.out.println("1. Create New Account");
	            System.out.println("2. Deposit into Account");
	            System.out.println("3. Withdraw Amount");
	            System.out.println("4. Get Balance of the Account");
	            System.out.println("5. Transfer to others");
	            System.out.println("6. Get Account Details");
	            System.out.println("7. List all the Accounts");
	            System.out.println("8. Check Transactions Between Date");
	            System.out.println("9. Exit Banking System ");

	            System.out.print("Please Enter your choice: ");
	            choice = scanner.nextInt();

	            switch (choice) {
	                case 1:
	                    createAccountMenu(bankServiceProvider, scanner);
	                    break;
	                case 2:
	                    depositMenu(bankServiceProvider, scanner);
	                    break;
	                case 3:
	                    withdrawMenu(bankServiceProvider, scanner);
	                    break;
	                case 4:
	                    getBalanceMenu(bankServiceProvider, scanner);
	                    break;
	                case 5:
	                    transferMenu(bankServiceProvider, scanner);
	                    break;
	                case 6:
	                    getAccountDetailsMenu(bankServiceProvider, scanner);
	                    break;
	                case 7:
	                    listAccounts(bankServiceProvider);
	                    break;
	                case 8:
	                    getTransactionsBetweenDate(bankServiceProvider, scanner);
	                    break;
	                case 9:
	                    System.out.println("Exiting the Banking System. Goodbye!");
	                    break;
	                default:
	                    System.out.println("Invalid choice. Please enter a valid option.");
	            }

	        } while (choice != 9);

	        scanner.close();
	    }

	       private static void createAccountMenu(IBankServiceProvider bankServiceProvider, Scanner scanner) {
	        System.out.println("<----- Create Account Menu ----->");
	        System.out.println("Select the type of account that you wish to create");
	        System.out.println("1. Savings Account");
	        System.out.println("2. Current Account");
	        System.out.println("3. ZeroBalance");

	        System.out.print("Enter account type choice: ");
	        int accountTypeChoice = scanner.nextInt();

	        System.out.print("Enter customer ID: ");
	        int customerid = scanner.nextInt();

	        System.out.print("Enter first name: ");
	        String firstname = scanner.next();

	        System.out.print("Enter last name: ");
	        String lastname = scanner.next();

	        System.out.print("Enter email address: ");
	        String email = scanner.next();

	        System.out.print("Enter phone number: ");
	        String phonenumber = scanner.next();

	        System.out.print("Enter address: ");
	        String address = scanner.next();

	        System.out.print("Enter Date of Birth (yyyy-MM-dd): ");
	        String DOB = scanner.next();

	        Customer customer = new Customer(customerid, firstname, lastname, email, phonenumber, address, DOB);

	        System.out.print("Enter initial balance: ");
	        double initialBalance = scanner.nextDouble();

	        switch (accountTypeChoice) {
	            case 1:
	                bankServiceProvider.createAccount(customer, Account.generateAccountid(), "Savings", initialBalance);
	                break;
	            case 2:
	                bankServiceProvider.createAccount(customer, Account.generateAccountid(), "Current", initialBalance);
	                break;
	            case 3:
	                bankServiceProvider.createAccount(customer, Account.generateAccountid(), "ZeroBalance", initialBalance);
	                break;
	            default:
	                System.out.println("Invalid account type choice.");
	        }
	    }


	    private static void depositMenu(IBankServiceProvider bankServiceProvider, Scanner scanner) throws Exception {
	        BankServiceProviderImpl bankService = (BankServiceProviderImpl) bankServiceProvider;
	        System.out.print("Enter account number to deposit into: ");
	        long accountid = scanner.nextLong();

	        System.out.print("Enter deposit amount: ");
	        double amount = scanner.nextDouble();

	        try {
	            bankService.deposit(accountid, amount);
	        } catch (InvalidAccountException e) {
	            System.out.println("Invalid Account Number");
	        }
	    }

	    private static void withdrawMenu(IBankServiceProvider bankServiceProvider, Scanner scanner) throws Exception {
	        BankServiceProviderImpl bankService = (BankServiceProviderImpl) bankServiceProvider;
	        System.out.print("Enter account number to withdraw from: ");
	        long accountid = scanner.nextLong();

	        System.out.print("Enter withdrawal amount: ");
	        double amount = scanner.nextDouble();

	        try {
	            bankService.withdraw(accountid, amount);
	        } catch (OverDraftLimitExceededException e) {
	            System.out.println("Withdraw Failed");
	        } catch (InvalidAccountException e) {
	            System.out.println("Invalid Account withdraw Failed");
	        }
	    }

	    private static void getBalanceMenu(IBankServiceProvider bankServiceProvider, Scanner scanner) {
	        BankServiceProviderImpl bankService = (BankServiceProviderImpl) bankServiceProvider;
	        System.out.print("Enter account number to get balance: ");
	        long accountid = scanner.nextLong();

	        try {
	            double newBalance = bankService.getBalance(accountid);
	            System.out.println("Current balance for account " + accountid + ": Rs." + newBalance);
	        } catch (InvalidAccountException e

	        ) {
	            System.out.println("No account exist with account number " + accountid);
	        }
	    }

	    private static void transferMenu(IBankServiceProvider bankServiceProvider, Scanner scanner) throws Exception {
	        BankServiceProviderImpl bankService = (BankServiceProviderImpl) bankServiceProvider;
	        
	        // Get input for account IDs and amount to transfer
	        System.out.print("Enter from account number: ");
	        long fromAccountid = scanner.nextLong();

	        System.out.print("Enter to account number: ");
	        long toAccountid = scanner.nextLong();

	        System.out.print("Enter transfer amount: ");
	        double amount = scanner.nextDouble();

	        // Try to transfer the amount
	        try {
	            // Call the transfer method with the correct parameters
	            bankService.transfer(fromAccountid, toAccountid, (float) amount);
	            System.out.println("Transfer successful");
	        } catch (OverDraftLimitExceededException e) {
	            System.out.println("Transfer Failed: Overdraft limit exceeded");
	        } catch (InvalidAccountException e) {
	            System.out.println("Transfer Failed: Invalid account");
	        } catch (InsufficientFundException e) {
	            System.out.println("Transfer Failed: Insufficient funds");
	        } catch (Exception e) {
	            System.out.println("Transfer Failed: " + e.getMessage());
	        }
	    }
	    private static void getTransactionsBetweenDate(IBankServiceProvider bankServiceProvider, Scanner scanner) {
			// TODO Auto-generated method stub
	    	BankServiceProviderImpl bankService=(BankServiceProviderImpl) bankServiceProvider;
	    	System.out.println("Enter account number:");
	        long accountid = scanner.nextLong();

	        System.out.println("Enter start date (YYYY-MM-DD):");
	        String startDateStr = scanner.next();
	        
	        if (!isValidDateFormat(startDateStr, "yyyy-MM-dd")) {
	            System.out.println("Invalid date format. Please use YYYY-MM-DD format.");
	            return;
	        }
	        
	        System.out.println("Enter end date (YYYY-MM-DD):");
	        String endDateStr = scanner.next();

	        if (!isValidDateFormat(endDateStr, "yyyy-MM-dd")) {
	            System.out.println("Invalid date format. Please use YYYY-MM-DD format.");
	            return; // Exit the method if the date format is invalid
	        }
	        
	        List<Transactions> transactions = bankService.getTransactionsBetweenDate(accountid, startDateStr, endDateStr);

	        if (transactions != null && !transactions.isEmpty()) {
	            System.out.println("Transactions between " + startDateStr + " and " + endDateStr + ":");
	            for (Transactions transaction : transactions) {
	                System.out.println("Transaction Type: " + transaction.getTransaction_type());
	                System.out.println("Transaction Amount: " + transaction.getAmount());
	                System.out.println("Transaction ID: " + transaction.getTransactionid());
	                System.out.println("Date and Time: " + transaction.getTransactiondate());
	                System.out.println("-------------------------------------");
	            }
	        } else {
	            System.out.println("No transactions found between " + startDateStr + " and " + endDateStr);
	        }  
	        
		}   


		private static void getAccountDetailsMenu(IBankServiceProvider bankServiceProvider, Scanner scanner) {
	        BankServiceProviderImpl bankService = (BankServiceProviderImpl) bankServiceProvider;
	        System.out.print("Enter from account number: ");
	        long accountid = scanner.nextLong();
	        try {
	            System.out.println(bankService.getAccountDetails(accountid));
	        } catch (InvalidAccountException e) {
	            System.out.println("Invalid Account Number");
	        }
	    }

	    private static void listAccounts(IBankServiceProvider bankServiceProvider) {
	        System.out.println("===== List of Accounts =====");
	        try {
	            Map<Long, Account> accountList = bankServiceProvider.listAccounts();
	            for (Map.Entry<Long, Account> entry : accountList.entrySet()) {
	                Account account = entry.getValue();
	                System.out.println("Account Number: " + account.getAccountid() +
	                        ", Type: " + account.getAccounttype() +
	                        ", Balance: Rs." + account.getBalance());
	            }

	        } catch (NullPointerException e) {
	            System.out.println("NullPointerException caught: " + e.getMessage());
	        }
	    }

	    private static boolean isValidDateFormat(String dateStr, String format) {
	        try {
	            SimpleDateFormat dateFormat = new SimpleDateFormat(format);
	            dateFormat.setLenient(false);
	            dateFormat.parse(dateStr);
	            return true;
	        } catch (ParseException e) {
	            return false;
	        }
	    }

		public static String getLastname() {
			return lastname;
		}

		public static void setLastname(String lastname) {
			BankApp.lastname = lastname;
		}

		public static String getFirstname() {
			return firstname;
		}

		public static void setFirstname(String firstname) {
			BankApp.firstname = firstname;
		}

		public static int getCustomerid() {
			return customerid;
		}

		public static void setCustomerid(int customerid) {
			BankApp.customerid = customerid;
		}

		public static long getPhonenumber() {
			return phonenumber;
		}

		public static void setPhonenumber(long phonenumber) {
			BankApp.phonenumber = phonenumber;
		}
	}