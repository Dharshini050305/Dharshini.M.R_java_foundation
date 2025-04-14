package entity;

public class Account {
	 private int accountNumber;
	    private String accountType;
	    private double accountBalance;

	    public Account(int accountNumber, String accountType, double accountBalance) {
	        this.accountNumber = accountNumber;
	        this.accountType = accountType;
	        this.accountBalance = accountBalance;
	    }

	    public int getAccountNumber() { 
	    	return accountNumber; 
	    	}
	    public String getAccountType() 
	    { return accountType; 
	    }
	    public double getAccountBalance() {
	    	return accountBalance; 
	    	}

	    public void setAccountBalance(double accountBalance) {
	        this.accountBalance = accountBalance;
	    }

	    public void printAccountInfo() {
	        System.out.println("Account Number: " + accountNumber);
	        System.out.println("Account Type: " + accountType);
	        System.out.println("Account Balance: $" + accountBalance);
	    }

	    public void deposit(double amount) {
	        if (amount > 0) {
	            accountBalance += amount;
	            System.out.println("Deposited $" + amount + " successfully.");
	        } else {
	            System.out.println("Invalid deposit amount.");
	        }
	    }

	    public void withdraw(double amount) {
	        if (amount > 0 && amount <= accountBalance) {
	            accountBalance -= amount;
	            System.out.println("Withdrew $" + amount + " successfully.");
	        } else {
	            System.out.println("Insufficient balance or invalid amount.");
	        }
	    }

	    public void calculateInterest() {
	        if (accountType.equalsIgnoreCase("Savings")) {
	            double interestRate = 4.5;
	            double interest = (accountBalance * interestRate) / 100;
	            accountBalance += interest;
	            System.out.println("Interest of $" + interest + " added at rate of " + interestRate + "%.");
	        } else {
	            System.out.println("Interest applicable only to Savings accounts.");
	        }
	    }
	}
