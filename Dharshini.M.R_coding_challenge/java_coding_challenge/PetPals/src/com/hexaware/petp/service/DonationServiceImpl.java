package com.hexaware.petp.service;

import com.hexaware.petp.dao.DonationDAO;
import com.hexaware.petp.dao.DonationDAOImpl;
import com.hexaware.petp.entity.CashDonation;
import com.hexaware.petp.exceptions.InsufficientFundsException;

public class DonationServiceImpl implements DonationService {

    private DonationDAO donationDAO;

    public DonationServiceImpl() {
        donationDAO = new DonationDAOImpl();
    }

    @Override
    public void processCashDonation(CashDonation donation) throws Exception {
        if (donation.getAmount() < 10.0) {
            throw new InsufficientFundsException("Donation amount must be at least $10.");
        }
        donationDAO.recordCashDonation(donation);
    }
}