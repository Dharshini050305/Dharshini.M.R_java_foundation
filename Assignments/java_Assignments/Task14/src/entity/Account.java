package entity;

public  class Account {
	private long accountid;
    private String accounttype;
    private double balance;
    private Customer customer;

    public Account(String accounttype, double balance, Customer customer) {
        this.accounttype = accounttype;
        this.balance = balance;
        this.customer = customer;
    }

    public long getAccountid() {
        return accountid;
    }

    public String getAccounttype() {
        return accounttype;
    }

    public double getBalance() {
        return balance;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setAccountid(long accountid) {
        this.accountid = accountid;
    }

    public void printAccountInfo() {
        System.out.println("Account Number: " + accountid);
        System.out.println("Account Type: " + accounttype);
        System.out.println("Account Balance: $" + balance);
        System.out.println("Customer Information:");
        customer.printInfo();
    }

    public static long generateAccountid() {
        
        return System.currentTimeMillis(); // Example only
    }
}