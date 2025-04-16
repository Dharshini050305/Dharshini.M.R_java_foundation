package com.hexaware.petp.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.hexaware.petp.DBUtil.DBUtil;
import com.hexaware.petp.entity.Participants;
public abstract class IAdoptEventImpl implements IAdoptEvent{
	
	private static final String Insert_participant="insert into participants( ParticipantID,ParticipantName,ParticipantType,EventID,PetID) values(?,?,?,?,?)";
	
	
	public void registerParticipant(Participants  participant){
		try(Connection con=DBUtil.getConnection("db.properties");PreparedStatement pstmt = con.prepareStatement(Insert_participant)){
			   System.out.println("connected");
			   pstmt.setInt(1, participant.getParticipantID());
			   pstmt.setString(2, participant.getParticipantName());
			   pstmt.setString(3, participant.getParticipantType());
			   pstmt.setInt(4, participant.getEventID());
			   pstmt.setInt(5, participant.getPetID());
			   
			   int rowsInserted = pstmt.executeUpdate();
       	    if (rowsInserted > 0) {
       	        System.out.println("A new participant added");
       	        System.out.println("Participant:"+participant.toString());
       	    } else {
       	        System.out.println("Failed to add participant");
       	    }
			   
		}catch(SQLException ex){
	    	System.err.println("error while adding participant");
	    	ex.printStackTrace();
	    }
	}
}
	