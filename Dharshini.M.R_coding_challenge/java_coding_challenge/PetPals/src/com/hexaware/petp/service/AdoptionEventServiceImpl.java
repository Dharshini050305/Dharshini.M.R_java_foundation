package com.hexaware.petp.service;

import java.sql.SQLException;

import com.hexaware.petp.dao.AdoptionEventDAOImpl;

public class AdoptionEventServiceImpl implements AdoptionEventService {

    private AdoptionEventDAOImpl adoptionEventDAO;

    public AdoptionEventServiceImpl() throws SQLException {
        adoptionEventDAO = new AdoptionEventDAOImpl();
    }

    @Override
    public void registerForEvent(String participantName, String role) {
        adoptionEventDAO.registerParticipant(participantName, role);
    }
}