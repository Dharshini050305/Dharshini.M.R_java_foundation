package service;

import entity.Account;
import entity.Customer;
import entity.SavingsAccount;
import exception.InvalidAccountException;
import exception.OverDraftLimitExceededException;

import java.util.HashMap;
import java.util.Map;

public class BankServiceProviderImpl implements IBankServiceProvider {
    private Map<Long, Account> accountList;

    // Constructor with optional accountList initialization
    public BankServiceProviderImpl(Map<Long, Account> accountList) {
        this.accountList = accountList != null ? accountList : new HashMap<>();
    }

    // Default constructor for no-argument initialization
    public BankServiceProviderImpl() {
        this.accountList = new HashMap<>();
    }

    @Override
    public float get_account_balance(long accountNumber) {
        Account account = accountList.get(Long.valueOf(accountNumber)); // Converts long to Long
        if (account != null) {
            return account.getAccountBalance();
        }
        throw new InvalidAccountException("Account number not found: " + accountNumber);
    }

    @Override
    public boolean deposit(long accountNumber, float amount) {
        Account account = accountList.get(Long.valueOf(accountNumber)); // Converts long to Long
        if (account != null) {
            account.setAccountBalance(account.getAccountBalance() + amount);
            System.out.println("Deposit successful. New balance: " + account.getAccountBalance());
            return true;
        } else {
            throw new InvalidAccountException("Account not found for deposit: " + accountNumber);
        }
    }


    @Override
    public boolean withdraw(long accountNumber, float amount) throws OverDraftLimitExceededException {
        Account account = accountList.get(Long.valueOf(accountNumber)); // Converts long to Long
        if (account != null) {
            if (account.getAccountBalance() >= amount) {
                account.setAccountBalance(account.getAccountBalance() - amount);
                System.out.println("Withdrawal successful. Remaining balance: " + account.getAccountBalance());
                return true;
            } else {
                throw new OverDraftLimitExceededException("Withdrawal amount exceeds overdraft limit.");
            }
        } else {
            throw new InvalidAccountException("Account not found for withdrawal: " + accountNumber);
        }
    }


    @Override
    public boolean transfer(long fromAccountNumber, long toAccountNumber, float amount) throws OverDraftLimitExceededException {
        if (withdraw(fromAccountNumber, amount)) {
            return deposit(toAccountNumber, amount);
        }
        System.out.println("Transfer failed.");
        return false;
    }

    @Override
    public Account getAccountDetails(long accountNumber) {
        Account account = accountList.get(Long.valueOf(accountNumber)); // Converts long to Long
        if (account != null) {
            return account;
        }
        throw new InvalidAccountException("Account not found: " + accountNumber);
    }

    @Override
    public void create_account(Customer customer, String accountType, float balance) {
        if (customer != null && accountType != null && !accountType.isEmpty()) {
            long accountNumber = Account.generateAccountNumber();
            Account newAccount = new Account(accountNumber, accountType, balance, customer);
            accountList.put(Long.valueOf(accountNumber), newAccount); // Converts long to Long
            System.out.println("Account created successfully: " + accountNumber);
        } else {
            throw new IllegalArgumentException("Invalid account details provided.");
        }
    }

    @Override
    public Account[] listAccounts() {
        return accountList.values().toArray(new Account[0]);
    }

    @Override
    public void calculateInterest() {
        for (Account account : accountList.values()) {
            if (account instanceof SavingsAccount) {
                SavingsAccount savingsAccount = (SavingsAccount) account;
                float interest = savingsAccount.getAccountBalance() * savingsAccount.getInterestRate() / 100;
                savingsAccount.setAccountBalance(savingsAccount.getAccountBalance() + interest);
                System.out.println("Interest added to account: " + savingsAccount.getAccountNumber());
            }
        }
    }
}