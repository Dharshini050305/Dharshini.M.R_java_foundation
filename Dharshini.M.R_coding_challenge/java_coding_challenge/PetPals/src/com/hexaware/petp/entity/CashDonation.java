package com.hexaware.petp.entity;
import java.time.LocalDateTime;

import java.time.LocalDate;

public abstract class CashDonation extends Donation {
    private LocalDate donationDate;

    public CashDonation(String donorName, double amount, LocalDate donationDate) {
        super(donorName, amount);
        this.donationDate = donationDate;
    }

    public LocalDate getDonationDate() { return donationDate; }
    public void setDonationDate(LocalDate donationDate) { this.donationDate = donationDate; }

    public void recordDonation(String amount) {
        System.out.println("Cash donation recorded from " + donorName + " on " + donationDate + " of amount $" + amount);
    }
}
