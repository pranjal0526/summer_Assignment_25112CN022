// Write a program to create ticket booking system.

import java.util.ArrayList;
import java.util.Scanner;

public class TicketBookingSystem {
    static class Ticket {
        int bookingId;
        String passengerName;
        String source;
        String destination;
        String journeyDate;
        int seatNumber;
        double fare;
        String status;

        Ticket(
            int bookingId,
            String passengerName,
            String source,
            String destination,
            String journeyDate,
            int seatNumber,
            double fare
        ) {
            this.bookingId = bookingId;
            this.passengerName = passengerName;
            this.source = source;
            this.destination = destination;
            this.journeyDate = journeyDate;
            this.seatNumber = seatNumber;
            this.fare = fare;
            this.status = "Booked";
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Ticket> tickets = new ArrayList<Ticket>();
        int choice;

        System.out.println("Ticket Booking System");

        do {
            System.out.println();
            System.out.println("1. Book Ticket");
            System.out.println("2. View All Tickets");
            System.out.println("3. Search Ticket");
            System.out.println("4. Update Ticket");
            System.out.println("5. Cancel Ticket");
            System.out.println("6. Delete Ticket");
            System.out.println("7. Exit");

            choice = readInt(sc, "Enter your choice: ");

            switch (choice) {
                case 1:
                    bookTicket(sc, tickets);
                    break;
                case 2:
                    viewTickets(tickets);
                    break;
                case 3:
                    searchTicket(sc, tickets);
                    break;
                case 4:
                    updateTicket(sc, tickets);
                    break;
                case 5:
                    cancelTicket(sc, tickets);
                    break;
                case 6:
                    deleteTicket(sc, tickets);
                    break;
                case 7:
                    System.out.println("Exiting ticket booking system.");
                    break;
                default:
                    System.out.println("Invalid choice. Please select between 1 and 7.");
            }
        } while (choice != 7);

        sc.close();
    }

    private static void bookTicket(Scanner sc, ArrayList<Ticket> tickets) {
        int bookingId = readInt(sc, "Enter booking ID: ");

        if (findTicket(tickets, bookingId) != null) {
            System.out.println("Ticket with this booking ID already exists.");
            return;
        }

        String passengerName = readNonEmptyString(sc, "Enter passenger name: ");
        String source = readNonEmptyString(sc, "Enter source: ");
        String destination = readNonEmptyString(sc, "Enter destination: ");

        if (source.equalsIgnoreCase(destination)) {
            System.out.println("Source and destination cannot be the same.");
            return;
        }

        String journeyDate = readNonEmptyString(sc, "Enter journey date: ");
        int seatNumber = readInt(sc, "Enter seat number: ");
        double fare = readDouble(sc, "Enter ticket fare: ");

        if (seatNumber <= 0 || fare < 0) {
            System.out.println("Seat number must be positive and fare cannot be negative.");
            return;
        }

        tickets.add(new Ticket(bookingId, passengerName, source, destination, journeyDate, seatNumber, fare));
        System.out.println("Ticket booked successfully.");
    }

    private static void viewTickets(ArrayList<Ticket> tickets) {
        if (tickets.isEmpty()) {
            System.out.println("No ticket bookings available.");
            return;
        }

        System.out.printf(
            "%-12s %-20s %-15s %-15s %-15s %-10s %-10s %-12s%n",
            "Booking ID",
            "Passenger",
            "Source",
            "Destination",
            "Date",
            "Seat",
            "Fare",
            "Status"
        );

        for (Ticket ticket : tickets) {
            System.out.printf(
                "%-12d %-20s %-15s %-15s %-15s %-10d %-10.2f %-12s%n",
                ticket.bookingId,
                ticket.passengerName,
                ticket.source,
                ticket.destination,
                ticket.journeyDate,
                ticket.seatNumber,
                ticket.fare,
                ticket.status
            );
        }
    }

    private static void searchTicket(Scanner sc, ArrayList<Ticket> tickets) {
        int bookingId = readInt(sc, "Enter booking ID to search: ");
        Ticket ticket = findTicket(tickets, bookingId);

        if (ticket == null) {
            System.out.println("Ticket not found.");
            return;
        }

        printTicketDetails(ticket);
    }

    private static void updateTicket(Scanner sc, ArrayList<Ticket> tickets) {
        int bookingId = readInt(sc, "Enter booking ID to update: ");
        Ticket ticket = findTicket(tickets, bookingId);

        if (ticket == null) {
            System.out.println("Ticket not found.");
            return;
        }

        if ("Cancelled".equals(ticket.status)) {
            System.out.println("Cancelled tickets cannot be updated.");
            return;
        }

        String passengerName = readNonEmptyString(sc, "Enter new passenger name: ");
        String source = readNonEmptyString(sc, "Enter new source: ");
        String destination = readNonEmptyString(sc, "Enter new destination: ");

        if (source.equalsIgnoreCase(destination)) {
            System.out.println("Source and destination cannot be the same.");
            return;
        }

        String journeyDate = readNonEmptyString(sc, "Enter new journey date: ");
        int seatNumber = readInt(sc, "Enter new seat number: ");
        double fare = readDouble(sc, "Enter new fare: ");

        if (seatNumber <= 0 || fare < 0) {
            System.out.println("Seat number must be positive and fare cannot be negative.");
            return;
        }

        ticket.passengerName = passengerName;
        ticket.source = source;
        ticket.destination = destination;
        ticket.journeyDate = journeyDate;
        ticket.seatNumber = seatNumber;
        ticket.fare = fare;
        System.out.println("Ticket updated successfully.");
    }

    private static void cancelTicket(Scanner sc, ArrayList<Ticket> tickets) {
        int bookingId = readInt(sc, "Enter booking ID to cancel: ");
        Ticket ticket = findTicket(tickets, bookingId);

        if (ticket == null) {
            System.out.println("Ticket not found.");
            return;
        }

        if ("Cancelled".equals(ticket.status)) {
            System.out.println("Ticket is already cancelled.");
            return;
        }

        ticket.status = "Cancelled";
        System.out.println("Ticket cancelled successfully.");
    }

    private static void deleteTicket(Scanner sc, ArrayList<Ticket> tickets) {
        int bookingId = readInt(sc, "Enter booking ID to delete: ");
        Ticket ticket = findTicket(tickets, bookingId);

        if (ticket == null) {
            System.out.println("Ticket not found.");
            return;
        }

        tickets.remove(ticket);
        System.out.println("Ticket deleted successfully.");
    }

    private static void printTicketDetails(Ticket ticket) {
        System.out.println("Ticket found:");
        System.out.println("Booking ID     : " + ticket.bookingId);
        System.out.println("Passenger Name : " + ticket.passengerName);
        System.out.println("Source         : " + ticket.source);
        System.out.println("Destination    : " + ticket.destination);
        System.out.println("Journey Date   : " + ticket.journeyDate);
        System.out.println("Seat Number    : " + ticket.seatNumber);
        System.out.printf("Fare           : %.2f%n", ticket.fare);
        System.out.println("Status         : " + ticket.status);
    }

    private static Ticket findTicket(ArrayList<Ticket> tickets, int bookingId) {
        for (Ticket ticket : tickets) {
            if (ticket.bookingId == bookingId) {
                return ticket;
            }
        }
        return null;
    }

    private static int readInt(Scanner sc, String message) {
        while (true) {
            System.out.print(message);
            if (sc.hasNextInt()) {
                int value = sc.nextInt();
                sc.nextLine();
                return value;
            }
            System.out.println("Please enter a valid integer.");
            sc.next();
        }
    }

    private static double readDouble(Scanner sc, String message) {
        while (true) {
            System.out.print(message);
            if (sc.hasNextDouble()) {
                double value = sc.nextDouble();
                sc.nextLine();
                return value;
            }
            System.out.println("Please enter a valid number.");
            sc.next();
        }
    }

    private static String readNonEmptyString(Scanner sc, String message) {
        while (true) {
            System.out.print(message);
            String value = sc.nextLine().trim();
            if (!value.isEmpty()) {
                return value;
            }
            System.out.println("Input cannot be empty.");
        }
    }
}
