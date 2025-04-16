package com.hexaware.petp.service;

import com.hexaware.petp.entity.Pet;
import java.util.List;

public interface PetService {
    void addPet(Pet pet) throws Exception;
    List<Pet> getAllPets();
    void removePet(String name);
}