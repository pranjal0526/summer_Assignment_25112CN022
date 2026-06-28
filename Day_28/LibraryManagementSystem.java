// Write a program to create library management system.

import java.util.ArrayList;
import java.util.Scanner;

public class LibraryManagementSystem {
    static class Book {
        int bookId;
        String title;
        String author;
        String category;
        boolean isIssued;

        Book(int bookId, String title, String author, String category) {
            this.bookId = bookId;
            this.title = title;
            this.author = author;
            this.category = category;
            this.isIssued = false;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Book> books = new ArrayList<Book>();
        int choice;

        System.out.println("Library Management System");

        do {
            System.out.println();
            System.out.println("1. Add Book");
            System.out.println("2. View All Books");
            System.out.println("3. Search Book");
            System.out.println("4. Update Book");
            System.out.println("5. Issue Book");
            System.out.println("6. Return Book");
            System.out.println("7. Delete Book");
            System.out.println("8. Exit");

            choice = readInt(sc, "Enter your choice: ");

            switch (choice) {
                case 1:
                    addBook(sc, books);
                    break;
                case 2:
                    viewBooks(books);
                    break;
                case 3:
                    searchBook(sc, books);
                    break;
                case 4:
                    updateBook(sc, books);
                    break;
                case 5:
                    issueBook(sc, books);
                    break;
                case 6:
                    returnBook(sc, books);
                    break;
                case 7:
                    deleteBook(sc, books);
                    break;
                case 8:
                    System.out.println("Exiting library management system.");
                    break;
                default:
                    System.out.println("Invalid choice. Please select between 1 and 8.");
            }
        } while (choice != 8);

        sc.close();
    }

    private static void addBook(Scanner sc, ArrayList<Book> books) {
        int bookId = readInt(sc, "Enter book ID: ");

        if (findBook(books, bookId) != null) {
            System.out.println("Book with this ID already exists.");
            return;
        }

        String title = readNonEmptyString(sc, "Enter book title: ");
        String author = readNonEmptyString(sc, "Enter author name: ");
        String category = readNonEmptyString(sc, "Enter category: ");

        books.add(new Book(bookId, title, author, category));
        System.out.println("Book added successfully.");
    }

    private static void viewBooks(ArrayList<Book> books) {
        if (books.isEmpty()) {
            System.out.println("No books available in the library.");
            return;
        }

        System.out.printf(
            "%-10s %-25s %-20s %-18s %-12s%n",
            "Book ID",
            "Title",
            "Author",
            "Category",
            "Status"
        );

        for (Book book : books) {
            System.out.printf(
                "%-10d %-25s %-20s %-18s %-12s%n",
                book.bookId,
                book.title,
                book.author,
                book.category,
                book.isIssued ? "Issued" : "Available"
            );
        }
    }

    private static void searchBook(Scanner sc, ArrayList<Book> books) {
        int bookId = readInt(sc, "Enter book ID to search: ");
        Book book = findBook(books, bookId);

        if (book == null) {
            System.out.println("Book not found.");
            return;
        }

        printBookDetails(book);
    }

    private static void updateBook(Scanner sc, ArrayList<Book> books) {
        int bookId = readInt(sc, "Enter book ID to update: ");
        Book book = findBook(books, bookId);

        if (book == null) {
            System.out.println("Book not found.");
            return;
        }

        book.title = readNonEmptyString(sc, "Enter new title: ");
        book.author = readNonEmptyString(sc, "Enter new author name: ");
        book.category = readNonEmptyString(sc, "Enter new category: ");
        System.out.println("Book details updated successfully.");
    }

    private static void issueBook(Scanner sc, ArrayList<Book> books) {
        int bookId = readInt(sc, "Enter book ID to issue: ");
        Book book = findBook(books, bookId);

        if (book == null) {
            System.out.println("Book not found.");
            return;
        }

        if (book.isIssued) {
            System.out.println("Book is already issued.");
            return;
        }

        book.isIssued = true;
        System.out.println("Book issued successfully.");
    }

    private static void returnBook(Scanner sc, ArrayList<Book> books) {
        int bookId = readInt(sc, "Enter book ID to return: ");
        Book book = findBook(books, bookId);

        if (book == null) {
            System.out.println("Book not found.");
            return;
        }

        if (!book.isIssued) {
            System.out.println("Book is already available in the library.");
            return;
        }

        book.isIssued = false;
        System.out.println("Book returned successfully.");
    }

    private static void deleteBook(Scanner sc, ArrayList<Book> books) {
        int bookId = readInt(sc, "Enter book ID to delete: ");
        Book book = findBook(books, bookId);

        if (book == null) {
            System.out.println("Book not found.");
            return;
        }

        books.remove(book);
        System.out.println("Book deleted successfully.");
    }

    private static void printBookDetails(Book book) {
        System.out.println("Book found:");
        System.out.println("Book ID   : " + book.bookId);
        System.out.println("Title     : " + book.title);
        System.out.println("Author    : " + book.author);
        System.out.println("Category  : " + book.category);
        System.out.println("Status    : " + (book.isIssued ? "Issued" : "Available"));
    }

    private static Book findBook(ArrayList<Book> books, int bookId) {
        for (Book book : books) {
            if (book.bookId == bookId) {
                return book;
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
