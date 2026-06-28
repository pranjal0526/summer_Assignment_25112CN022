// Write a program to create contact management system.

import java.util.ArrayList;
import java.util.Scanner;

public class ContactManagementSystem {
    static class Contact {
        int contactId;
        String name;
        String phoneNumber;
        String email;
        String address;

        Contact(int contactId, String name, String phoneNumber, String email, String address) {
            this.contactId = contactId;
            this.name = name;
            this.phoneNumber = phoneNumber;
            this.email = email;
            this.address = address;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Contact> contacts = new ArrayList<Contact>();
        int choice;

        System.out.println("Contact Management System");

        do {
            System.out.println();
            System.out.println("1. Add Contact");
            System.out.println("2. View All Contacts");
            System.out.println("3. Search Contact");
            System.out.println("4. Update Contact");
            System.out.println("5. Delete Contact");
            System.out.println("6. Exit");

            choice = readInt(sc, "Enter your choice: ");

            switch (choice) {
                case 1:
                    addContact(sc, contacts);
                    break;
                case 2:
                    viewContacts(contacts);
                    break;
                case 3:
                    searchContact(sc, contacts);
                    break;
                case 4:
                    updateContact(sc, contacts);
                    break;
                case 5:
                    deleteContact(sc, contacts);
                    break;
                case 6:
                    System.out.println("Exiting contact management system.");
                    break;
                default:
                    System.out.println("Invalid choice. Please select between 1 and 6.");
            }
        } while (choice != 6);

        sc.close();
    }

    private static void addContact(Scanner sc, ArrayList<Contact> contacts) {
        int contactId = readInt(sc, "Enter contact ID: ");

        if (findContact(contacts, contactId) != null) {
            System.out.println("Contact with this ID already exists.");
            return;
        }

        String name = readNonEmptyString(sc, "Enter contact name: ");
        String phoneNumber = readNonEmptyString(sc, "Enter phone number: ");
        String email = readNonEmptyString(sc, "Enter email: ");
        String address = readNonEmptyString(sc, "Enter address: ");

        if (!isValidPhoneNumber(phoneNumber)) {
            System.out.println("Phone number should contain 10 to 15 digits only.");
            return;
        }

        if (!isValidEmail(email)) {
            System.out.println("Please enter a valid email address.");
            return;
        }

        contacts.add(new Contact(contactId, name, phoneNumber, email, address));
        System.out.println("Contact added successfully.");
    }

    private static void viewContacts(ArrayList<Contact> contacts) {
        if (contacts.isEmpty()) {
            System.out.println("No contacts available.");
            return;
        }

        System.out.printf(
            "%-12s %-20s %-18s %-28s %-25s%n",
            "Contact ID",
            "Name",
            "Phone",
            "Email",
            "Address"
        );

        for (Contact contact : contacts) {
            System.out.printf(
                "%-12d %-20s %-18s %-28s %-25s%n",
                contact.contactId,
                contact.name,
                contact.phoneNumber,
                contact.email,
                contact.address
            );
        }
    }

    private static void searchContact(Scanner sc, ArrayList<Contact> contacts) {
        int contactId = readInt(sc, "Enter contact ID to search: ");
        Contact contact = findContact(contacts, contactId);

        if (contact == null) {
            System.out.println("Contact not found.");
            return;
        }

        printContactDetails(contact);
    }

    private static void updateContact(Scanner sc, ArrayList<Contact> contacts) {
        int contactId = readInt(sc, "Enter contact ID to update: ");
        Contact contact = findContact(contacts, contactId);

        if (contact == null) {
            System.out.println("Contact not found.");
            return;
        }

        String name = readNonEmptyString(sc, "Enter new contact name: ");
        String phoneNumber = readNonEmptyString(sc, "Enter new phone number: ");
        String email = readNonEmptyString(sc, "Enter new email: ");
        String address = readNonEmptyString(sc, "Enter new address: ");

        if (!isValidPhoneNumber(phoneNumber)) {
            System.out.println("Phone number should contain 10 to 15 digits only.");
            return;
        }

        if (!isValidEmail(email)) {
            System.out.println("Please enter a valid email address.");
            return;
        }

        contact.name = name;
        contact.phoneNumber = phoneNumber;
        contact.email = email;
        contact.address = address;
        System.out.println("Contact updated successfully.");
    }

    private static void deleteContact(Scanner sc, ArrayList<Contact> contacts) {
        int contactId = readInt(sc, "Enter contact ID to delete: ");
        Contact contact = findContact(contacts, contactId);

        if (contact == null) {
            System.out.println("Contact not found.");
            return;
        }

        contacts.remove(contact);
        System.out.println("Contact deleted successfully.");
    }

    private static void printContactDetails(Contact contact) {
        System.out.println("Contact found:");
        System.out.println("Contact ID   : " + contact.contactId);
        System.out.println("Name         : " + contact.name);
        System.out.println("Phone Number : " + contact.phoneNumber);
        System.out.println("Email        : " + contact.email);
        System.out.println("Address      : " + contact.address);
    }

    private static Contact findContact(ArrayList<Contact> contacts, int contactId) {
        for (Contact contact : contacts) {
            if (contact.contactId == contactId) {
                return contact;
            }
        }
        return null;
    }

    private static boolean isValidPhoneNumber(String phoneNumber) {
        return phoneNumber.matches("\\d{10,15}");
    }

    private static boolean isValidEmail(String email) {
        int atIndex = email.indexOf('@');
        int dotIndex = email.lastIndexOf('.');
        return atIndex > 0 && dotIndex > atIndex + 1 && dotIndex < email.length() - 1;
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
