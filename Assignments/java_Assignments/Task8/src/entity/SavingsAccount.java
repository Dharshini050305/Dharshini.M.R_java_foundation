package entity;

public class SavingsAccount extends Account {
    private double interestRate;

    public SavingsAccount(int accountNumber, double balance, double interestRate) {
        super(accountNumber, "Savings", balance);
        this.interestRate = interestRate;
    }
    @Override
    public void calculateInterest() {
        double interest = (accountBalance * interestRate) / 100;
        accountBalance += interest;
        System.out.println("Interest of $" + interest + " added at " + interestRate + "%.");
    }
}