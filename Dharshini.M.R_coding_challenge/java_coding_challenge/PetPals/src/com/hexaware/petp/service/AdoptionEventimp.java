package com.hexaware.petp.service;

import java.util.ArrayList;
import java.util.List;

public class AdoptionEventimp implements IAdoptable{
	
    private List<IAdoptable> participants;
    


    public void AdoptionEvent() {
        participants = new ArrayList<>();
    }

    public void registerParticipant(IAdoptable participant) {
        participants.add(participant);
        System.out.println("Participant registered: " + participant);
    }

    public void hostEvent() {
        System.out.println("Adoption Event is starting!");
        for (IAdoptable participant : participants) {
            participant.adopt();
        }
        System.out.println("Adoption Event has ended!");
    }

	public void adopt() {}



}

