package entity;

import java.sql.Date;

public class Transactions {
	 private long accountid;
	    private long transactionid;
	    private Date transactiondate;
	    private String transactiontype;
	    private double amount;

	    public Transactions() {
	        // Default constructor
	    }

	    public Transactions(long accountid, long transactionid, String transactiontype, double amount, Date transactiondate) {
	        this.accountid = accountid;
	        this.transactionid = transactionid;
	        this.transactiontype = transactiontype;
	        this.amount = amount;
	        this.transactiondate = transactiondate;
	    }

	    public Transactions(long accountid, String transactiontype, double amount) {
	        this.accountid = accountid;
	        this.transactiontype = transactiontype;
	        this.amount = amount;
	        this.transactiondate = new Date(0, 0, 0); // Set current timestamp
	    }

	    public long getAccountid() {
	        return accountid;
	    }

	    public void setAccountid(long accountid) {
	        this.accountid = accountid;
	    }

	    public long getTransactionid() {
	        return transactionid;
	    }

	    public void setTransactionid(long transactionid) {
	        this.transactionid = transactionid;
	    }

	    public Date getTransactiondate() {
	        return transactiondate;
	    }

	    public void setTransactiondate(Date transactiondate) {
	        this.transactiondate = transactiondate;
	    }

	    public String getTransaction_type() {
	        return transactiontype;
	    }

	    public void setTransactiontype(String transactiontype) {
	        this.transactiontype = transactiontype;
	    }

	    public double getAmount() {
	        return amount;
	    }

	    public void setAmount(double amount) {
	        this.amount = amount;
	    }

	    @Override
	    public String toString() {
	        return "Transactions{" +
	                "accountid=" + accountid +
	                ", transactionid=" + transactionid +
	                ", transactiondate=" + transactiondate +
	                ", transactiontype='" + transactiontype + '\'' +
	                ", amount=" + amount +
	                '}';
	    }

		public void setTransactiondate(java.util.Date date) {
			this.transactiondate=transactiondate;
			
		}
	}