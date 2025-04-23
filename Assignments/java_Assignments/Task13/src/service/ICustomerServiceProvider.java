package service;

import java.util.List;

import entity.Transactions;
import exception.InvalidAccountException;
public interface ICustomerServiceProvider {
	 double getBalance(long accountid) throws InvalidAccountException;

	    double deposit(long accountid, double amount) throws Exception;

	    double withdraw(long accountid, double amount) throws Exception;

	    void transfer(long fromAccountid, long toAccountid, double amount) throws Exception;

	    String getAccountDetails(long accountid) throws InvalidAccountException;

		List<Transactions> getTransactionsBetweenDate(long accountid, String startDate, String endDate);

}
