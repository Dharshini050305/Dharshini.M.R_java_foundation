package entity;

public class Account {
	private static long lastAccNo = 1000;
    private long accountNumber;
    private String accountType;
    private float balance;
    private Customer customer;
    public Account(String accountType, float balance, Customer customer) {
        this.accountNumber = ++lastAccNo;
        this.accountType = accountType;
        this.balance = balance;
        this.customer = customer;
    }
    public Account(long l, Customer customer2, String accountType2, float initialBalance) {
        //TODO Auto-generated constructor stub
    }
    public long getAccountNumber() { return accountNumber; }
    public String getAccountType() { return accountType; }
    public float getBalance() { return balance; }
    public void setBalance(float balance) { this.balance = balance; }
    public Customer getCustomer() { return customer; }
    public String toString() {
        return "AccNo: " + accountNumber + ", Type: " + accountType + ", Balance: " + balance + ", Customer: [" + customer + "]";
    }

}

