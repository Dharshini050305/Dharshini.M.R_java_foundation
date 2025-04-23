package service;

import java.util.Map;

import entity.Account;
import entity.Customer;
public interface IBankServiceProvider {
	 void createAccount(Customer customer, long accountid, String accounttype, double balance);

	    Map<Long, Account> listAccounts();

}
