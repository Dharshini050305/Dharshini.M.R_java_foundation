package service;

import java.util.HashMap;

import entity.Account;
import entity.Customer;
public class BankServiceProviderImpl {
	private HashMap<Long, Account> accounts = new HashMap<>();
    private long accountNumberCounter = 1000; // Starting account number

    public void create_account(Customer customer, String accountType, float initialBalance) {
        Account account = new Account(accountNumberCounter++, customer, accountType, initialBalance);
        accounts.put(account.getAccountNumber(), account);
    }

    public float deposit(long accountNumber, float amount) {
        Account account = accounts.get(accountNumber);
        if (account != null) {
            account.setBalance(account.getBalance() + amount);
            return account.getBalance();
        }
        throw new IllegalArgumentException("Account not found.");
    }

    public float withdraw(long accountNumber, float amount) {
        Account account = accounts.get(accountNumber);
        if (account != null) {
            if (account.getBalance() >= amount) {
                account.setBalance(account.getBalance() - amount);
                return account.getBalance();
            } else {
                throw new IllegalArgumentException("Insufficient balance.");
            }
        }
        throw new IllegalArgumentException("Account not found.");
    }

    public float get_account_balance(long accountNumber) {
        Account account = accounts.get(accountNumber);
        if (account != null) {
            return account.getBalance();
        }
        throw new IllegalArgumentException("Account not found.");
    }

    public void transfer(long fromAccount, long toAccount, float amount) {
        Account from = accounts.get(fromAccount);
        Account to = accounts.get(toAccount);
        if (from != null && to != null) {
            withdraw(fromAccount, amount);
            deposit(toAccount, amount);
        } else {
            throw new IllegalArgumentException("One or both accounts not found.");
        }
    }

    public void getAccountDetails(long accountNumber) {
        Account account = accounts.get(accountNumber);
        if (account != null) {
            System.out.println("Account Number: " + account.getAccountNumber());
            System.out.println("Customer Name: " + account.getCustomer().getName());
            System.out.println("Account Type: " + account.getAccountType());
            System.out.println("Balance: " + account.getBalance());
        } else {
            throw new IllegalArgumentException("Account not found.");
        }
    }

    public void listAccounts() {
        for (Account account : accounts.values()) {
            System.out.println("Account Number: " + account.getAccountNumber() + ", Customer: " + account.getCustomer().getName() + ", Balance: " + account.getBalance());
        }
    }

    public void calculateInterest() {
        // Implement interest calculation logic here
    }
}

