package entity;

public class Customer {
	 private int customerID;
	    private String firstName;
	    private String lastName;
	    private String email;
	    private String phoneNumber;
	    private String address;

	    // Default constructor
	    public Customer() {
	        this.customerID = 0;
	        this.firstName = "";
	        this.lastName = "";
	        this.email = "";
	        this.phoneNumber = "";
	        this.address = "";
	    }

	    // Parameterized constructor
	    public Customer(int customerID, String firstName, String lastName, String email, String phoneNumber, String address) {
	        this.customerID = customerID;
	        this.firstName = firstName;
	        this.lastName = lastName;
	        this.email = email;
	        this.phoneNumber = phoneNumber;
	        this.address = address;
	    }

	    // Getters and setters
	    public int getCustomerID() {
	    	return customerID;
	    	}
	    public void setCustomerID(int customerID) {
	    	this.customerID = customerID; 
	    	}

	    public String getFirstName() {
	    	return firstName;
	    	}
	    public void setFirstName(String firstName) { 
	    	this.firstName = firstName; 
	    	}

	    public String getLastName() { 
	    	return lastName; 
	    	}
	    public void setLastName(String lastName) {
	    	this.lastName = lastName; 
	    	}

	    public String getEmail() {
	    	return email; 
	    	}
	    public void setEmail(String email) {
	    	this.email = email; 
	    	}

	    public String getPhoneNumber() {
	    	return phoneNumber; 
	    	}
	    public void setPhoneNumber(String phoneNumber) {
	    	this.phoneNumber = phoneNumber; 
	    	}

	    public String getAddress() {
	    	return address; 
	    	}
	    public void setAddress(String address) {
	    	this.address = address; 
	    	}

	    // Method to display customer info
	    public void printCustomerInfo() {
	        System.out.println("Customer ID: " + customerID);
	        System.out.println("Name: " + firstName + " " + lastName);
	        System.out.println("Email: " + email);
	        System.out.println("Phone: " + phoneNumber);
	        System.out.println("Address: " + address);
	    }
	    @Override
	    public String toString() {
	        return "Customer [customerId=" + customerID + ", firstName=" + firstName + ", lastName=" + lastName
	                + ", emailAddress=" + email + ", phoneNumber=" + phoneNumber + ", address=" + address + "]";
	    }
	}
