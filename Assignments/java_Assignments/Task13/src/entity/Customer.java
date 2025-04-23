package entity;

public class Customer {
	 private int customerid;
	    private String firstname;
	    private String lastname;
	    private String dob;
	    private String email;
	    private String phonenumber;
	    private String address;

	    public Customer(int customerid, String firstname, String lastname, String email, String phonenumber, String address , String dob2) {
	        this.customerid = customerid;
	        this.firstname = firstname;
	        this.lastname = lastname;
	        this.dob = dob2;
	        this.email = email;
	        this.phonenumber = phonenumber;
	        this.address = address;
	        this.address = address;
	    }

	    public int getCustomerid() {
	        return customerid;
	    }

	    public String getFirstname() {
	        return firstname;
	    }

	    public String getLastname() {
	        return lastname;
	    }

	    public String getEmail() {
	        return email;
	    }

	    public String getPhonenumber() {
	        return phonenumber;
	    }

	    public String getAddress() {
	        return address;
	    }
	    public String getDob() {
	    	return dob;
	    }
	    public void setCustomerid(int customerid) {
	        this.customerid = customerid;
	    }

	    public void setFirstname(String firstname) {
	        this.firstname = firstname;
	    }

	    public void setLastname(String lastname) {
	        this.lastname = lastname;
	    }

	    public void setEmail(String email) {
	        this.email = email;
	    }

	    public void setPhonenumber(String phonenumber) {
	        this.phonenumber = phonenumber;
	    }

	    public void setAddress(String address) {
	        this.address = address;
	    }

	    public void setDob(String dob) {
	        this.dob = dob;
	    }

	    // toString method for easy printing of Customer details
	    @Override
	    public String toString() {
	        return "Customer{" +
	                "customerid=" + customerid +
	                ", firstname='" + firstname + '\'' +
	                ", lastname='" + lastname + '\'' +
	                ", dob='" + dob + '\'' +
	                ", email='" + email + '\'' +
	                ", phonenumber='" + phonenumber + '\'' +
	                ", address='" + address + '\'' +
	                '}';
	    }
	

	    public void printInfo() {
	        System.out.println("Customer ID: " + customerid);
	        System.out.println("First Name: " + firstname);
	        System.out.println("Last Name: " + lastname);
	        System.out.println("DOB: " + dob);
	        System.out.println("Email Address: " + email);
	        System.out.println("Phone Number: " + phonenumber);
	        System.out.println("Address: " + address);
	    }

	
		
		}

		
		
	