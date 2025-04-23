package service;

import entity.Customer;

public  interface IBank {
	   void create_account(Customer customer, String accType, float balance) ;
	   abstract float get_account_balance(long account_number);
	   float deposit(long account_number, float amount);
	   float withdraw(long account_number, float amount);
	   void transfer(long from_account_number, long to_account_number, float amount);
	   void getAccountDetails(long account_number);
}
