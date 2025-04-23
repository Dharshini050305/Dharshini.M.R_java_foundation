package service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import entity.Account;
import entity.CurrentAccount;
import entity.Customer;
import entity.SavingsAccount;
import entity.Transactions;
import exception.InsufficientFundException;
import exception.InvalidAccountException;
import exception.OverDraftLimitExceededException;
public class BankServiceProviderImpl extends CustomerServiceProviderImpl implements IBankServiceProvider {
	private Map<Long, Account> accountList;
    BankRepositoryImpl bankdb;
    public BankServiceProviderImpl() throws Exception {

        bankdb= new BankRepositoryImpl() ;
        accountList=listAccounts();
    }

    @Override
    public void createAccount(Customer customerid, long accountid, String accounttype, double balance) {
        Account account = null;

        switch (accounttype) {
            case "Savings":
                account = new SavingsAccount(4.5, customerid); 
                break;
            case "Current":
                account = new CurrentAccount(0.0, customerid);
                break;
            case "ZeroBalance":
        }
		account.setAccountid(accountid);
        account.setBalance(balance);

       accountList.put(accountid,account);
      
        bankdb.createAccount(customerid, accountid, accounttype, (float) balance);
	}

    @Override
    public Map<Long, Account> listAccounts() {
    	accountList=castToMap(bankdb.listAccounts());

    	if(accountList.isEmpty())
    	{
    		throw new NullPointerException("No Accounts created");
    	}
        return accountList;
    }

    private Map<Long, Account> castToMap(List<Account> listAccounts) {
		// TODO Auto-generated method stub
    	Map<Long,Account> hm;
    	hm=new HashMap<>();
        for (Account listAccount : listAccounts) {
            hm.put(listAccount.getAccountid(), listAccount);

        }
		return hm;
	}

    public Account findAccountObject(long accountid)
    {
    	if(accountList.get(accountid)!=null)
    	{
    		return accountList.get(accountid);
    	}
    	return null;
    }

    @Override
    public double getBalance(long accountid) throws InvalidAccountException {
    	Account acc=findAccountObject(accountid);
    	if(acc==null)
    	{
    		throw new InvalidAccountException("No account Found");
    	}
    	return bankdb.getBalance(accountid);
    }

    public double deposit(long accountid, double amount) throws Exception {
    	Account acc=findAccountObject(accountid);
    	if(acc==null)
    	{
    		System.out.println("Receiver Account Invalid");
    		throw new InvalidAccountException("Receiver Account Invalid");
    	}
    	acc.setBalance(acc.getBalance()+amount);

        Transactions transaction = new Transactions();
		transaction.setTransactiontype("Deposit");
		transaction.getTransactiondate();
        bankdb.deposit(accountid, (float) amount);
		bankdb.addTransaction(transaction);
		accountList = listAccounts();
		return bankdb.getBalance(accountid);

    }

	@Override
	public double withdraw(long accountid, double amount) throws Exception {
		Account account = findAccountObject(accountid);
		if (account != null) {
			if (account.getBalance() >= amount) {
				double newBalance = account.getBalance() - amount;
				account.setBalance(newBalance);
				bankdb.withdraw(accountid, (float) amount);
				accountList.put(accountid, account);
				System.out.println("Transaction successful. New balance: Rs." + newBalance);
				return newBalance;
			} else {
				throw new InsufficientFundException("Insufficient Funds in account");
			}
		} else {
			throw new InvalidAccountException("Account Not Found");
		}
	}

    @Override
    public void transfer(long fromAccountid, long toAccountid, double amount) throws Exception {

    	if(!accountList.containsKey(fromAccountid))
    	{
    		System.out.println("Sender Account Invalid");
    		throw new InvalidAccountException("Sender Account Invalid");
    	}
    	if(!accountList.containsKey(toAccountid))
    	{
    		System.out.println("Receiver Account Invalid");
    		throw new InvalidAccountException("Receiver Account Invalid");
    	}
    	try {
			withdraw(fromAccountid,amount);
		} catch (InvalidAccountException e) {
			// TODO Auto-generated catch block
			throw new InvalidAccountException("Sender Account Invalid");
		}
    	catch (InsufficientFundException e) {
			// TODO Auto-generated catch block
			throw new InsufficientFundException("Insufficient Funds in sender account");
		}
    	catch (OverDraftLimitExceededException e) {
			// TODO Auto-generated catch block
			throw new OverDraftLimitExceededException();
		}
    	deposit(toAccountid,amount);


        System.out.println("Transferred Rs." + amount + " from account " + fromAccountid + " to account " + toAccountid);
    }
    public String getAccountDetails(long accountid) throws InvalidAccountException {
    	Account account = findAccountObject(accountid);
    	if(account==null)
    	{
    		throw new InvalidAccountException("Invalid Account Number");
    	}
    	String customerDetails=" Customer firstname: "+account.getCustomer().getFirstname()+" Customer lastname: "+account.getCustomer().getLastname()+" Customer ID: "+account.getCustomer().getCustomerid()+" Customer email: "+account.getCustomer().getEmail()+" Customer Phonenumber: "+account.getCustomer().getPhonenumber()+" Customer address: "+account.getCustomer().getAddress();
    	String result=" Account Type: "+account.getAccounttype()+" Account Balance: "+account.getBalance();
        return "Account details for account number " + accountid+result+customerDetails;
    }
    @Override
	public List<Transactions> getTransactionsBetweenDate(long accountid, String startDate, String endDate) {
    	
		// TODO Auto-generated method stub
		return bankdb.getTransactionsBetweenDate(accountid, startDate, endDate);
}
    public static boolean validateAccountData(Account account) {
	    return account != null &&
	           account.getAccounttype() != null && account.getAccounttype().length() > 3 &&
	           account.getBalance() >= 0 &&
	           account.getCustomer() != null;
	}
}

