package entity;

public class ZeroBalanceAccount extends Account{
	public ZeroBalanceAccount(Customer customer) {
        super("ZeroBalance", 0, customer);
    }



	private float getAccountBalance() {
		// TODO Auto-generated method stub
		return 0;
	}
}


