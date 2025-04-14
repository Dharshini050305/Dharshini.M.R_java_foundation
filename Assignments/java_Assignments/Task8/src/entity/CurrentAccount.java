package entity;

public class CurrentAccount extends Account {
    private static final double OVERDRAFT_LIMIT = 1000;
    public CurrentAccount(int accountNumber, double balance) {
        super(accountNumber, "Current", balance);
    }
    @Override
    public void withdraw(double amount) {
        if (amount <= accountBalance + OVERDRAFT_LIMIT) {
            accountBalance -= amount;
            System.out.println("Withdrew: $" + amount);
        } else {
            System.out.println("Overdraft limit exceeded. Cannot withdraw.");
        }
    }
    @Override
    public void withdraw(int amount) {
        withdraw((double) amount);
    }
    @Override
    public void withdraw(float amount) {
        withdraw((double) amount);
    }
    @Override
    public void calculateInterest() {
        System.out.println("No interest for Current Accounts.");
    }
}