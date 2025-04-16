package com.hexaware.petp.presentation;

import java.sql.SQLException;
import java.util.Scanner;

import com.hexaware.petp.dao.AdoptionEvent;
import com.hexaware.petp.dao.CashDonation;
import com.hexaware.petp.dao.PetShelter;
import com.hexaware.petp.entity.Cat;
import com.hexaware.petp.entity.Dog;
import com.hexaware.petp.exceptions.InsufficientFundsException;
import com.hexaware.petp.exceptions.InvalidPetAgeException;

public class ClientUI {
    public static void main(String[] args) throws SQLException, InvalidPetAgeException {
    	PetShelter shelter = new PetShelter();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nPet Adoption Platform");
            System.out.println("1. Add Pet");
            System.out.println("2. List Available Pets");
            System.out.println("3. Record Cash Donation");
            System.out.println("4. Host Adoption Event");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter pet name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter pet age: ");
                    int age = scanner.nextInt();
                    scanner.nextLine(); 
                    System.out.print("Enter pet breed: ");
                    String breed = scanner.nextLine();
                    System.out.print("Enter type (dog/cat): ");
                    String type = scanner.nextLine();

                    if (type.equalsIgnoreCase("dog")) {
                        System.out.print("Enter dog breed: ");
                        String dogBreed = scanner.nextLine();
                        Dog dog = new Dog();
						shelter.addPet();
                    } else if (type.equalsIgnoreCase("cat")) {
                        System.out.print("Enter cat color: ");
                        String catColor = scanner.nextLine();
                        Cat cat = new Cat();
						shelter.addPet();
                    } else {
                        System.out.println("Invalid pet type.");
                    }
                    break;

                case 2:
                    shelter.listAvailablePets();
                    break;

                case 3:
                    System.out.print("Enter donor name: ");
                    String donorName = scanner.nextLine();
                    System.out.print("Enter donation amount: ");
                    double cashAmount = scanner.nextDouble();

                    try {
                        if (cashAmount < 10) {
                            throw new InsufficientFundsException("Donation amount must be at least $10.");
                        }
                        CashDonation cashDonation = new CashDonation(donorName, cashAmount, null);
                        cashDonation.recordDonation();
                    } catch (InsufficientFundsException e) {
                        System.out.println("Error: " + e.getMessage());
                    }

                    break;

                case 4:
                	AdoptionEvent adoptionEvent = new AdoptionEvent(null);
                    System.out.print("Enter participant name: ");
                    String participantName = scanner.nextLine();
                    adoptionEvent.registerParticipant();

                    adoptionEvent.hostEvent();
                    break;

                case 5:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);

        scanner.close();
    }
}
