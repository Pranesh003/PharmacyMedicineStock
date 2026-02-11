package com.pharmacy.app;

import com.pharmacy.service.PharmacyService;
import com.pharmacy.util.*;
import java.util.Date;
import java.util.Scanner;

public class PharmacyMain {

    public static void main(String[] args) {

        PharmacyService service = new PharmacyService();
        Scanner sc = new Scanner(System.in);
        int choice;

        System.out.println("=== Pharmacy Medicine Stock & Prescription System ===");

        do {
            System.out.println("\n1. Issue Prescription");
            System.out.println("2. Cancel Prescription");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {

                case 1:
                    try {
                        System.out.print("Enter Medicine ID: ");
                        String medId = sc.nextLine();

                        System.out.print("Enter Patient Name: ");
                        String patient = sc.nextLine();

                        System.out.print("Enter Quantity: ");
                        int qty = sc.nextInt();

                        boolean result = service.issuePrescription(
                                medId, patient, qty, new Date());

                        if (result)
                            System.out.println("Prescription ISSUED successfully");
                        else
                            System.out.println("Failed to issue prescription");

                    } catch (ValidationException | OutOfStockException e) {
                        System.out.println(e);
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 2:
                    try {
                        System.out.print("Enter Prescription ID to cancel: ");
                        int pid = sc.nextInt();

                        boolean result = service.cancelPrescription(pid);

                        if (result)
                            System.out.println("Prescription CANCELLED successfully");
                        else
                            System.out.println("Prescription ID not found");

                    } catch (ValidationException e) {
                        System.out.println(e);
                    } catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 3:
                    System.out.println("Exiting Pharmacy System...");
                    break;

                default:
                    System.out.println("Invalid choice! Try again.");
            }

        } while (choice != 3);

        sc.close();
    }
}

