package service;

import entity.Account;

public interface ICustomerServiceProvider {
    float get_account_balance(long accountNumber);
    boolean deposit(long accountNumber, float amount);
    boolean withdraw(long accountNumber, float amount);
    boolean transfer(long fromAccountNumber, long toAccountNumber, float amount);
    Account getAccountDetails(long accountNumber);
}