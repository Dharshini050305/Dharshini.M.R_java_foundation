package entity;

public class Customer {
	
	  private int customerId;       
	    private String customerName;  
	    private String customerContact; 

	    // Constructor
	    public Customer(int customerId, String customerName, String customerContact) {
	        this.customerId = customerId;
	        this.customerName = customerName;
	        this.customerContact = customerContact;
	    }

	    // Getters and Setters
	    public int getCustomerId() {
	        return customerId;
	    }

	    public void setCustomerId(int customerId) {
	        this.customerId = customerId;
	    }

	    public String getCustomerName() {
	        return customerName;
	    }

	    public void setCustomerName(String customerName) {
	        this.customerName = customerName;
	    }

	    public String getCustomerContact() {
	        return customerContact;
	    }

	    public void setCustomerContact(String customerContact) {
	        this.customerContact = customerContact;
	    }

	    // toString Method
	    @Override
	    public String toString() {
	        return "Customer{" +
	                "customerId=" + customerId +
	                ", customerName='" + customerName + '\'' +
	                ", customerContact='" + customerContact + '\'' +
	                '}';
	    }

	
	}
