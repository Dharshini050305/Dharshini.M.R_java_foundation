package com.hexaware.petp.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import java.sql.PreparedStatement;
import java.util.Scanner;

import com.hexaware.petp.entity.Participants;

public class AdoptionEvent<IAdoptable> {
    // Attribute
    private List<IAdoptable> participants;
    Participants p;
	private Object DBPropertyUtil;
    // Constructor
    public AdoptionEvent(ArrayList Participants) {
        Participants = new ArrayList<>();
    }

    // Method to host the adoption event
    @SuppressWarnings("static-access")
	public void hostEvent() {
    	try {
        	// Load the JDBC driver and get the connection string
            String fileName = "db.properties";
            String mainConnectionString = null; // Initialize the connection string variable
            try {
                Object DBUtil = null;
				mainConnectionString = (( (com.hexaware.petp.dao.DBUtil) DBUtil).getConnectionString(fileName));
            } catch (Exception e) {
                // Handle the exception gracefully
                System.out.println("Error: Failed to retrieve connection string from properties file. " + e.getMessage());
                return; // Exit the method if unable to retrieve the connection string
            }

            
         // Load the JDBC driver
            try {
                Class.forName(((DBUtil) DBPropertyUtil).getDriver(fileName));
            } catch (ClassNotFoundException e) {
                // Handle the exception gracefully
                System.out.println("Error: MySQL JDBC Driver not found. " + e.getMessage());
                return; // Exit the method if JDBC driver not found
            }
            // Connect to the database and load the JDBC driver
            try (Connection conn = DBUtil.getConnection(fileName)) {
            	try (PreparedStatement pstmt = conn.prepareStatement("INSERT INTO adoptionevents(EventID, EventName,EventDate,Location,SID) VALUES (?, ?, ?, ?, ?)")) {
            	    // Set parameters for each placeholder
            		Scanner sc= new Scanner(System.in);
            		System.out.println("EventID");
            		int EventID = sc.nextInt();
            		System.out.println("Event Name");
            	    String EventName=sc.next();
            		System.out.println("Event Date");
            	    String EventDate=sc.next();
            		System.out.println("Location");
            		String Location=sc.next();
            		System.out.println("SID");
            		int SID = sc.nextInt();
            	    pstmt.setInt(1, EventID); // petID
            	    pstmt.setString(2, EventName); // name
            	    pstmt.setDate(3,java.sql.Date.valueOf(EventDate) ); // age
            	    pstmt.setString(4,Location); // breed
            	    pstmt.setInt(5, SID); // type
            	   
            	    // Execute the PreparedStatement
            	    int rowsInserted = pstmt.executeUpdate();
            	    if (rowsInserted > 0) {
            	        System.out.println("A new Event has been Hosted.");
            	    } else {
            	        System.out.println("Failed to Host Event");
            	    }
            	}
            	
                catch (SQLException e) {
                    System.out.println("Error: Failed to fetch Event. " + e.getMessage());
                }
            } catch (SQLException e) {
                System.out.println("Error: Failed to connect to the database. " + e.getMessage());
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    	System.out.println("Event Hosted");
        System.out.println("Adoption event hosted!");
       
    }

    // Method to register a participant for the event
    public void registerParticipant() {
       // participants.add(participant);
        
    	try {
        	// Load the JDBC driver and get the connection string
            String fileName = "db.properties";
            String mainConnectionString = null; // Initialize the connection string variable
            try {
                mainConnectionString = ((DBUtil) DBPropertyUtil).getConnectionString(fileName);
            } catch (Exception e) {
                // Handle the exception gracefully
                System.out.println("Error: Failed to retrieve connection string from properties file. " + e.getMessage());
                return; // Exit the method if unable to retrieve the connection string
            }

            
         // Load the JDBC driver
            try {
                Class.forName(((DBUtil) DBPropertyUtil).getDriver(fileName));
            } catch (ClassNotFoundException e) {
                // Handle the exception gracefully
                System.out.println("Error: MySQL JDBC Driver not found. " + e.getMessage());
                return; // Exit the method if JDBC driver not found
            }
            // Connect to the database and load the JDBC driver
            try (Connection conn = DBUtil.getConnection(fileName)) {
            	try (PreparedStatement pstmt = conn.prepareStatement("INSERT INTO participants(participantID, participantName,participantType,EventID,PetID) VALUES (?, ?, ?, ?,?)")) {
            	    // Set parameters for each placeholder
            		Scanner sc= new Scanner(System.in);
            		System.out.println("Participant ID");
            		int participantID = sc.nextInt();
            		System.out.println("Participant  Name");
            	    String participantName=sc.next();
            		System.out.println("Participant Type");
            	    String participantType=sc.next();
            		System.out.println("Event ID");
            		int EventID = sc.nextInt();
            		System.out.println("pet ID");
            		int petID = sc.nextInt();
            		p=new Participants(participantID,participantName,participantType,EventID,petID);
            	    pstmt.setInt(1,p.getParticipantID()); // petID
            	    pstmt.setString(2, p.getParticipantName()); // name
            	    pstmt.setString(3,p.getParticipantType()); // breed
            	    pstmt.setInt(4, p.getEventID()); // type
            	    pstmt.setInt(5, p.getPetID());
            	   
            	    // Execute the PreparedStatement
            	    int rowsInserted = pstmt.executeUpdate();
            	    if (rowsInserted > 0) {
            	        System.out.println("A new participant added");
            	        System.out.println("Participant:"+p.toString());
            	    } else {
            	        System.out.println("Failed to add participant");
            	    }
            	}
            	
                catch (SQLException e) {
                    System.out.println("Error: Failed to fetch Participant. " + e.getMessage());
                }
            } catch (SQLException e) {
                System.out.println("Error: Failed to connect to the database. " + e.getMessage());
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    	System.out.println("participant added");
        
    }

    public void manageAdoptionEvents() {
        try {
            String fileName = "db.properties";
            String mainConnectionString = null; // Initialize the connection string variable
            try {
                mainConnectionString = ((DBUtil) DBPropertyUtil).getConnectionString(fileName);
            } catch (Exception e) {
                // Handle the exception gracefully
                System.out.println("Error: Failed to retrieve connection string from properties file. " + e.getMessage());
                return; // Exit the method if unable to retrieve the connection string
            }

            // Load the JDBC driver
            try {
                Class.forName(((DBUtil) DBPropertyUtil).getDriver(fileName));
            } catch (ClassNotFoundException e) {
                // Handle the exception gracefully
                System.out.println("Error: MySQL JDBC Driver not found. " + e.getMessage());
                return; // Exit the method if JDBC driver not found
            }

            // Connect to the database
            try (Connection conn = DBUtil.getConnection(fileName)) {
                try (Statement stmt = conn.createStatement();
                     ResultSet rs = stmt.executeQuery("SELECT * FROM adoptionevents where EventDate>'2024-04-13'")) {
                    
                    System.out.println("=== Adoption Events ===");
                    while (rs.next()) {
                        System.out.println("Event ID: " + rs.getInt("EventId") + ", Event Name: " + rs.getString("EventName") + ", Date: " + rs.getDate("EventDate")+",ShelterID:"+rs.getInt("SID"));
                    }
                } catch (SQLException e) {
                    System.out.println("Error: Failed to fetch adoption events. " + e.getMessage());
                }
            } catch (SQLException e) {
                System.out.println("Error: Failed to connect to the database. " + e.getMessage());
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

	public void registerParticipant(Participants participant) {
		
		
	}
}