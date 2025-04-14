package service;

import entity.Account;

public interface IBankServiceProvider {
    void createAccount1(Account account); // Accepts an Account object
    void deposit(long accountNumber, double amount);
    void withdraw(long accountNumber, double amount);
    void transfer(long fromAccount, long toAccount, double amount);
    double getAccountBalance(long accountNumber);
	void createAccount(entity.Account account);
}