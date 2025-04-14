package service;

import entity.Account;
import entity.CurrentAccount;
import entity.SavingsAccount;
import exception.InsufficientFundException;
import exception.InvalidAccountException;
import exception.OverDraftLimitExcededException;
public class CustomerServiceProviderImpl implements ICustomerServiceProvider{
	 protected Account[] accounts = new Account[100];
	    protected int index = 0;
	    protected Account findAccount(long accNo) {
	        for (Account acc : accounts) {
	            if (acc != null && acc.getAccountNumber() == accNo)
	                return acc;
	        }
	        return null;
	    }
	    public float get_account_balance(long accNo) throws InvalidAccountException {
	        Account acc = findAccount(accNo);
	        if (acc == null) throw new InvalidAccountException("Account not found");
	        return acc.getBalance();
	    }
	    public float deposit(long accNo, float amount) throws InvalidAccountException {
	        Account acc = findAccount(accNo);
	        if (acc == null) throw new InvalidAccountException("Account not found");
	        acc.setBalance(acc.getBalance() + amount);
	        return acc.getBalance();
	    }
	    public float withdraw(long accNo, float amount) throws InvalidAccountException, InsufficientFundException, OverDraftLimitExcededException {
	        Account acc = findAccount(accNo);
	        if (acc == null) throw new InvalidAccountException("Account not found");

	        if (acc instanceof SavingsAccount) {
	            if (acc.getBalance() - amount < 500)
	                throw new InsufficientFundException("Maintain min balance 500");
	            acc.setBalance(acc.getBalance() - amount);
	        } else if (acc instanceof CurrentAccount) {
	            float available = acc.getBalance() + ((CurrentAccount) acc).getOverdraftLimit();
	            if (amount > available)
	                throw new OverDraftLimitExcededException("Overdraft limit exceeded");
	            acc.setBalance(acc.getBalance() - amount);
	        } else {
	            if (acc.getBalance() < amount)
	                throw new InsufficientFundException("Insufficient funds");
	            acc.setBalance(acc.getBalance() - amount);
	        }
	        return acc.getBalance();
	    }
	    public void transfer(long fromAcc, long toAcc, float amount) throws InvalidAccountException, InsufficientFundException, OverDraftLimitExcededException {
	        Account from = findAccount(fromAcc);
	        Account to = findAccount(toAcc);
	        if (from == null || to == null)
	            throw new InvalidAccountException("One or both account numbers are invalid");
	        withdraw(fromAcc, amount);
	        deposit(toAcc, amount);
	    }
	    public String getAccountDetails(long accNo) throws InvalidAccountException {
	        Account acc = findAccount(accNo);
	        if (acc == null) throw new InvalidAccountException("Account not found");
	        return acc.toString();
	    }
}
