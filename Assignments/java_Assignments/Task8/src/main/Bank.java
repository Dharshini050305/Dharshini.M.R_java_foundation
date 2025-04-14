package main;

import entity.Account;
import entity.CurrentAccount;
import entity.SavingsAccount;

import java.util.*;

public class Bank {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Account account = null;
        System.out.println("Welcome to the Bank!");
        System.out.println("Choose account type to create:");
        System.out.println("1. Savings Account");
        System.out.println("2. Current Account");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();
        System.out.print("Enter Account Number: ");
        int accNum = scanner.nextInt();
        System.out.print("Enter Initial Balance: ");
        double balance = scanner.nextDouble();
        switch (choice) {
            case 1:
                System.out.print("Enter Interest Rate (%): ");
                double rate = scanner.nextDouble();
                account = new SavingsAccount(accNum, balance, rate);
                break;
            case 2:
                account = new CurrentAccount(accNum, balance);
                break;
            default:
                System.out.println("Invalid choice.");
                System.exit(0);
        }
        // Menu loop
        int option;
        do {
            System.out.println("\n--- BANK MENU ---");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Calculate Interest");
            System.out.println("4. Check Balance");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            option = scanner.nextInt();
            switch (option) {
                case 1:
                    System.out.print("Enter amount to deposit: ");
                    double dep = scanner.nextDouble();
                    account.deposit(dep);
                    break;
                case 2:
                    System.out.print("Enter amount to withdraw: ");
                    double wd = scanner.nextDouble();
                    account.withdraw(wd);
                    break;
                case 3:
                    account.calculateInterest();
                    break;
                case 4:
                    account.displayBalance();
                    break;
                case 5:
                    System.out.println("Thank you for banking with us!");
                    break;
                default:
                    System.out.println("Invalid option.");
            }
        } while (option != 5);

        scanner.close();
    }
}