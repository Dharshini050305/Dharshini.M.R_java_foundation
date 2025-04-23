package service;

import entity.Account;
import entity.CurrentAccount;
import entity.Customer;
import entity.SavingsAccount;
import entity.Transactions;
import exception.InvalidAccountException;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;


	public class CustomerServiceProviderImpl implements ICustomerServiceProvider {

	    @Override
	    public double getBalance(long accountid) throws InvalidAccountException {

	        return 0;
	    }

	    @Override
	    public double deposit(long accountid, double amount) throws Exception {


	        return amount;
	    }
	    @Override
	    public double withdraw(long accountid, double amount) throws Exception {
	        return 0.0;
	    }
	    @Override
	    public void transfer(long fromAccountid, long toAccountid, double amount) throws Exception {
	        System.out.println("Transferred Rs." + amount + " fromAccount " + fromAccountid + " to account " + toAccountid);
	    }
	    @Override
	    public String getAccountDetails(long accountid) throws InvalidAccountException {
	        return "Account details for account number " + accountid;
	    }
	    @Override
		public List<Transactions> getTransactionsBetweenDate(long accountid, String startDate, String endDate) {
			// TODO Auto-generated method stub
			return null;
		}
	    public static boolean validateCustomerData(Customer customer) {
	        return customer != null &&
	               customer.getFirstname() != null && customer.getFirstname().length() > 2 &&
	               customer.getEmail() != null && customer.getEmail().contains("@") &&
	               customer.getPhonenumber() != null && customer.getPhonenumber().length() >= 10;
	    }
	   

	    }
