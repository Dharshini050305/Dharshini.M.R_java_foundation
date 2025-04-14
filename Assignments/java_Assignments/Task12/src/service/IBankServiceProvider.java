package service;

import entity.Account;
import entity.Customer;

public interface IBankServiceProvider extends ICustomerServiceProvider {
    void create_account(Customer customer, String accountType, float balance);
    Account[] listAccounts();
    void calculateInterest();
}