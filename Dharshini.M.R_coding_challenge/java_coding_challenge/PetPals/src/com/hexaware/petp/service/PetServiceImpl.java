package com.hexaware.petp.service;

import com.hexaware.petp.dao.PetDAO;
import com.hexaware.petp.dao.PetDAOImpl;
import com.hexaware.petp.entity.Pet;
import com.hexaware.petp.exceptions.InvalidPetAgeException;

import java.util.List;

public class PetServiceImpl implements PetService {

    private PetDAO petDAO;

    public PetServiceImpl() {
        petDAO = new PetDAOImpl();
    }

    @Override
    public void addPet(Pet pet) throws Exception {
        if (pet.getAge() <= 0) {
            throw new InvalidPetAgeException("Pet age must be a positive integer.");
        }
        petDAO.addPet(pet);
    }

    @Override
    public List<Pet> getAllPets() {
        return petDAO.getAllPets();
    }

    @Override
    public void removePet(String name) {
        petDAO.removePet(name);
    }
}