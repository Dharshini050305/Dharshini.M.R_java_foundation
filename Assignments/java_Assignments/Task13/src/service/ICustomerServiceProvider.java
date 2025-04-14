package service;

import entity.*;
import exception.InsufficientFundException;
import exception.InvalidAccountException;
import exception.OverDraftLimitExcededException;
public interface ICustomerServiceProvider {
	 float get_account_balance(long accountNumber) throws InvalidAccountException;
	    float deposit(long accountNumber, float amount) throws InvalidAccountException;
	    float withdraw(long accountNumber, float amount)
	        throws InvalidAccountException, InsufficientFundException, OverDraftLimitExcededException;
	    void transfer(long fromAccountNumber, long toAccountNumber, float amount)
	        throws InvalidAccountException, InsufficientFundException, OverDraftLimitExcededException;
	    String getAccountDetails(long accountNumber) throws InvalidAccountException;

}
