package com.hexaware.petp.entity;

public abstract class ItemDonation extends Donation {
    private String itemType;

    public ItemDonation(String donorName, double amount, String itemType) {
        super(donorName, amount);
        this.itemType = itemType;
    }

    public String getItemType() { return itemType; }
    public void setItemType(String itemType) { this.itemType = itemType; }

    public void recordDonation(String amount) {
        System.out.println("Item donation recorded from " + donorName + " - Item: " + itemType + ", Estimated Value: $" + amount);
    }
}