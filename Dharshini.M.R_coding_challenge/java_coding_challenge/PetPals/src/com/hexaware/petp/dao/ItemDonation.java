package com.hexaware.petp.dao;


public class ItemDonation extends Donation {
    
    private String itemType;

    // Constructor
    public ItemDonation(String donorName, double amount, String itemType) {
        super(donorName, amount);
        this.itemType = itemType;
    }

    public ItemDonation(String donorName, double amount) {
		
	}

	
    @Override
    public void recordDonation() {
       
        System.out.println("Item donation recorded for donor: " + getDonorName() +
                ", Amount: $" + getAmount() + ", Item Type: " + itemType);
    }

    // Example usage
    public static void main(String[] args) {
      
        ItemDonation itemDonation = new ItemDonation("Jane Smith", 50.25, "Toys");

     
        itemDonation.recordDonation();
    }
}