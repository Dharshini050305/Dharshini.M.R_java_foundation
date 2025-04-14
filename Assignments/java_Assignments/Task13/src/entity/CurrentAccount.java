package entity;

public class CurrentAccount extends Account{
	private float overdraftLimit;
    public CurrentAccount(float balance, Customer customer, float overdraftLimit) {
        super("Current", balance, customer);
        this.overdraftLimit = overdraftLimit;
    }
    public float getOverdraftLimit() { return overdraftLimit; }
}

