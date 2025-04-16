package com.hexaware.petp.dao;

import com.hexaware.petp.entity.CashDonation;

public interface DonationDAO {
    void recordCashDonation(CashDonation donation);
}