package service;

import java.util.List;

import entity.Account;
import entity.Customer;
import entity.Transactions;
import exception.InsufficientFundException;
import exception.InvalidAccountException;
import exception.OverDraftLimitExceededException;

public interface IBankRepository {
	 void createAccount(Customer customer, long accountid, String accounttype, float balance);

	    List<Account> listAccounts();

	    float getBalance(long accountid);

	    void deposit(long accountid, float amount) throws Exception;

	    void withdraw(long accountid, float amount) throws OverDraftLimitExceededException, InsufficientFundException, InvalidAccountException;

		List<Transactions> getTransactionsBetweenDate(long accountid, String fromDate, String toDate);
}
