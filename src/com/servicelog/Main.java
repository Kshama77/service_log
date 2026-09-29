package com.servicelog;

import com.servicelog.model.Appointment;
import com.servicelog.service.AppointmentService;

import java.util.List;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final AppointmentService service = new AppointmentService();

    public static void main(String[] args) {
        boolean running = true;

        System.out.println("================================");
        System.out.println("        Welcome to ServiceLog");
        System.out.println("   Service Appointment Tracker");
        System.out.println("================================");

        while (running) {
            showMenu();
            int choice = readInt("Choose an option: ");

            switch (choice) {
                case 1 -> addAppointment();
                case 2 -> viewAppointments();
                case 3 -> searchAppointments();
                case 4 -> updateStatus();
                case 5 -> deleteAppointment();
                case 6 -> {
                    running = false;
                    System.out.println("Thank you for using ServiceLog!");
                }
                default -> System.out.println("Invalid option. Please try again.");
            }
        }

        scanner.close();
    }

    private static void showMenu() {
        System.out.println();
        System.out.println("----------- Menu -----------");
        System.out.println("1. Add Appointment");
        System.out.println("2. View Appointments");
        System.out.println("3. Search by Customer");
        System.out.println("4. Update Status");
        System.out.println("5. Delete Appointment");
        System.out.println("6. Exit");
        System.out.println("----------------------------");
    }

    private static void addAppointment() {
        System.out.println();
        System.out.println("--- Add Appointment ---");

        String customer = readText("Customer name: ");
        String serviceType = readText("Service type: ");
        String date = readText("Date (MM/DD/YYYY): ");
        String time = readText("Time: ");

        service.addAppointment(customer, serviceType, date, time);
        System.out.println("Appointment added successfully.");
    }

    private static void viewAppointments() {
        System.out.println();
        System.out.println("--- All Appointments ---");

        List<Appointment> appointments = service.getAllAppointments();

        if (appointments.isEmpty()) {
            System.out.println("No appointments found.");
            return;
        }

        for (Appointment appointment : appointments) {
            System.out.println(appointment);
        }
    }

    private static void searchAppointments() {
        System.out.println();
        System.out.println("--- Search Appointments ---");

        String customer = readText("Enter customer name: ");
        List<Appointment> results = service.searchByCustomer(customer);

        if (results.isEmpty()) {
            System.out.println("No appointments found.");
            return;
        }

        for (Appointment appointment : results) {
            System.out.println(appointment);
        }
    }

    private static void updateStatus() {
        System.out.println();
        System.out.println("--- Update Status ---");

        int id = readInt("Appointment ID: ");
        String status = readText(
            "New status (Scheduled/Completed/Cancelled): "
        );

        if (service.updateStatus(id, status)) {
            System.out.println("Appointment status updated.");
        } else {
            System.out.println("Appointment not found.");
        }
    }

    private static void deleteAppointment() {
        System.out.println();
        System.out.println("--- Delete Appointment ---");

        int id = readInt("Appointment ID: ");

        if (service.deleteAppointment(id)) {
            System.out.println("Appointment deleted.");
        } else {
            System.out.println("Appointment not found.");
        }
    }

    private static String readText(String message) {
        System.out.print(message);
        return scanner.nextLine().trim();
    }

    private static int readInt(String message) {
        while (true) {
            try {
                System.out.print(message);
                return Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }
}
