package entity;

public class Account {
	 private static long lastAccNo = 1000L; 
	    private long accountNumber;          
	    private String accountType;          
	    private float accountBalance;        
	    private Customer customer;           

	    // Constructor
	    public Account(String accountType, float accountBalance, Customer customer) {
	        this.accountNumber = ++lastAccNo; // Auto-generate account number.
	        this.accountType = accountType;
	        this.accountBalance = accountBalance;
	        this.customer = customer;
	    }

	    public Account(long accountNumber2, String accountType2, float balance, Customer customer2) {
	    	this.accountNumber = accountNumber;
	        this.accountType = accountType;
	        this.accountBalance = balance;
	        this.customer = customer;
		}

		// Getters and Setters
	    public long getAccountNumber() {
	        return accountNumber;
	    }

	    public String getAccountType() {
	        return accountType;
	    }

	    public void setAccountType(String accountType) {
	        this.accountType = accountType;
	    }

	    public float getAccountBalance() {
	        return accountBalance;
	    }

	    public void setAccountBalance(float accountBalance) {
	        this.accountBalance = accountBalance;
	    }

	    public Customer getCustomer() {
	        return customer;
	    }

	    public void setCustomer(Customer customer) {
	        this.customer = customer;
	    }

	    // Deposit Method
	    public void deposit(float amount) {
	        if (amount > 0) {
	            this.accountBalance += amount;
	            System.out.println("Amount deposited successfully! New Balance: " + accountBalance);
	        } else {
	            System.out.println("Invalid deposit amount.");
	        }
	    }

	    // Withdraw Method
	    public boolean withdraw(float amount) {
	        if (amount > 0 && amount <= accountBalance) {
	            this.accountBalance -= amount;
	            System.out.println("Amount withdrawn successfully! Remaining Balance: " + accountBalance);
	            return true;
	        } else {
	            System.out.println("Invalid withdrawal amount or insufficient balance.");
	            return false;
	        }
	    }

	    // Print Account Details
	    public void printAccountDetails() {
	        System.out.println("Account Details:");
	        System.out.println("Account Number: " + accountNumber);
	        System.out.println("Account Type: " + accountType);
	        System.out.println("Account Balance: " + accountBalance);
	        System.out.println("Customer Details: " + customer.toString());
	    }

		public static long generateAccountNumber() {
			
			return lastAccNo++;
		}
		@Override
		public String toString() {
			return "Account Details:\n" +
			           "Account Number: " + accountNumber + "\n" +
			           "Account Type: " + accountType + "\n" +
			           "Account Balance: " + accountBalance + "\n" 
			           ; // assumes Customer has a useful toString()
			}
}
