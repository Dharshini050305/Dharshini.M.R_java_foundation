package entity;

public class Customer {
	 private String name;
	    private int age;

	    // Default constructor
	    public Customer() {}

	    //  Parameterized constructor
	    public Customer(String name, int age) {
	        this.name = name;
	        this.age = age;
	    }

	    // Setters
	    public void setName(String name) {
	        this.name = name;
	    }

	    public void setAge(int age) {
	        this.age = age;
	    }

	  
	    public String getName() {
	        return name;
	    }

	    public int getAge() {
	        return age;
	    }

	    @Override
	    public String toString() {
	        return "Customer{name='" + name + "', age=" + age + "}";
	    }
	}


