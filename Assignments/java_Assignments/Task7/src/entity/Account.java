package entity;

public class Account {
	 private int accountNumber;
	    private String accountType;
	    private double accountBalance;
	    private static final double INTEREST_RATE = 4.5;
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

	    public void setAccountNumber(int accountNumber) {
	        this.accountNumber= accountNumber;
	    }
	    public void setAccountType(String accountType) {
	        this.accountType = accountType;
	    }
	    public void setAccountBalance(double accountBalance) {
	        this.accountBalance = accountBalance;
	    }
	    public boolean deposit(double deposit) {
	        if (deposit > 0) {
	            accountBalance += deposit;
	            System.out.println("Amount " + deposit + " deposited successfully.");
	            System.out.println("New balance: " + accountBalance);
	            return true;
	        } else {
	            System.out.println("Invalid deposit amount. Amount must be positive.");
	            return false;
	        }
	    }
	    
	    // Method to withdraw money from the account
	    public boolean withdraw(double withdraw) {
	        if (withdraw <= 0) {
	            System.out.println("Invalid withdrawal amount. Amount must be positive.");
	            return false;
	        } else if (withdraw > accountBalance) {
	            System.out.println("Insufficient balance. Current balance: " + accountBalance);
	            return false;
	        } else {
	            accountBalance -= withdraw;
	            System.out.println("Amount " + withdraw + " withdrawn successfully.");
	            System.out.println("Remaining balance: " + accountBalance);
	            return true;
	        }
	    }
	    
	    // Method to calculate interest
	    public double calculateInterest() {
	        double interestAmount = accountBalance * (INTEREST_RATE / 100);
	        System.out.println("Interest calculated at " + INTEREST_RATE + "% rate: " + interestAmount);
	        return interestAmount;
	    }
	    
	    // Method to print account information
	    public void printAccountInfo() {
	        System.out.println("Account Information:");
	        System.out.println("Account Number: " + accountNumber);
	        System.out.println("Account Type: " + accountType);
	        System.out.println("Account Balance: " + accountBalance);
	    }
	}


