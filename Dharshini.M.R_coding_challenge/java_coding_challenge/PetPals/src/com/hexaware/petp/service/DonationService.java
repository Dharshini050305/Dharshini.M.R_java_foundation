package com.hexaware.petp.service;

import com.hexaware.petp.entity.CashDonation;

public interface DonationService {
    void processCashDonation(CashDonation donation) throws Exception;
}