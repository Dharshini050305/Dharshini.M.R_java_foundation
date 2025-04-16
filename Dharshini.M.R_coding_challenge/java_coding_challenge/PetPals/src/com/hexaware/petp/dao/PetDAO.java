package com.hexaware.petp.dao;

import com.hexaware.petp.entity.Pet;
import java.util.List;

public interface PetDAO {
    void addPet(Pet pet);
    List<Pet> getAllPets();
    void removePet(String name);
}