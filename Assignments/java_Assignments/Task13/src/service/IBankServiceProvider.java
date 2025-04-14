package service;

import entity.Customer;
public interface IBankServiceProvider {
	  void create_account(Customer customer, String accType, float balance);
	    void listAccounts();
	    void calculateInterest();

}
