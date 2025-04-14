package entity;

public class Account {
	protected int accountNumber;
    protected String accountType;
    protected double accountBalance;

    public Account(int accountNumber, String accountType, double accountBalance) {
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.accountBalance = accountBalance;
    }

    // Overloaded deposit methods
    public void deposit(float amount) {
        accountBalance += amount;
        System.out.println("Deposited: $" + amount);
    }

    public void deposit(int amount) {
        accountBalance += amount;
        System.out.println("Deposited: $" + amount);
    }

    public void deposit(double amount) {
        accountBalance += amount;
        System.out.println("Deposited: $" + amount);
    }

    // Overloaded withdraw methods
    public void withdraw(float amount) {
        if (amount <= accountBalance) {
            accountBalance -= amount;
            System.out.println("Withdrew: $" + amount);
        } else {
            System.out.println("Insufficient balance.");
        }
    }

    public void withdraw(int amount) {
        if (amount <= accountBalance) {
            accountBalance -= amount;
            System.out.println("Withdrew: $" + amount);
        } else {
            System.out.println("Insufficient balance.");
        }
    }

    public void withdraw(double amount) {
        if (amount <= accountBalance) {
            accountBalance -= amount;
            System.out.println("Withdrew: $" + amount);
        } else {
            System.out.println("Insufficient balance.");
        }
    }

    public void calculateInterest() {
        System.out.println("No interest calculation for generic accounts.");
    }

    public void displayBalance() {
        System.out.println("Current Balance: $" + accountBalance);
    }
}
