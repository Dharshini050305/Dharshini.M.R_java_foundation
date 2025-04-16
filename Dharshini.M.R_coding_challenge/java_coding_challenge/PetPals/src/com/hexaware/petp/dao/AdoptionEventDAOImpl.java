package com.hexaware.petp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class AdoptionEventDAOImpl extends AdoptionEventDAO {

    private Connection conn;
	private Statement DBConnUtil;

    public AdoptionEventDAOImpl() throws SQLException {
        conn = DBConnUtil.getConnection();
    }

    public void registerParticipant(String participantName, String role) {
        String sql = "INSERT INTO participants (name, role) VALUES (?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, participantName);
            stmt.setString(2, role);
            stmt.executeUpdate();
            System.out.println("Participant registered.");
        } catch (SQLException e) {
            System.out.println("DB Error (RegisterParticipant): " + e.getMessage());
        }
    }
}