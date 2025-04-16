package com.hexaware.petp.entity;
import java.time.LocalDateTime;

import com.hexaware.petp.dao.ItemDonation;

public class CashDonation extends ItemDonation {
  
    private LocalDateTime donationDate;

    
    public CashDonation(String donorName, double amount, LocalDateTime donationDate) {
        super(donorName, amount);
        this.donationDate = donationDate;
    }

  
    @Override
    public void recordDonation() {
       
        System.out.println("Cash donation recorded for donor: " + getDonorName() +
                ", Amount: $" + getAmount() + ", Date: " + donationDate);
    }

   
    public static void main(String[] args) {
        
        CashDonation cashDonation = new CashDonation("John Doe", 100.50, LocalDateTime.now());

    
        cashDonation.recordDonation();
    }
}
