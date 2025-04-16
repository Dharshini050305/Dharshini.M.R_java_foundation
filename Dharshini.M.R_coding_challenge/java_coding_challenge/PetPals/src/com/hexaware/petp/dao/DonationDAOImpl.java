package com.hexaware.petp.dao;

import com.hexaware.petp.DBUtil.DBConnUtil;
import com.hexaware.petp.entity.CashDonation;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DonationDAOImpl implements DonationDAO {

    private Connection conn;

    public DonationDAOImpl() {
        conn = DBConnUtil.getConnection();
    }

    @Override
    public void recordCashDonation(CashDonation donation) {
        String sql = "INSERT INTO donations (donor_name, amount, donation_date) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, donation.getDonorName());
            stmt.setDouble(2, donation.getAmount());
            stmt.setDate(3, java.sql.Date.valueOf(donation.getDonationDate()));
            stmt.executeUpdate();
            System.out.println("Donation recorded.");
        } catch (SQLException e) {
            System.out.println("DB Error (RecordDonation): " + e.getMessage());
        }
    }
}