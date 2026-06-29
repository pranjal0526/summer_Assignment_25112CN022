// Write a program to create inventory management system.

import java.util.ArrayList;
import java.util.Scanner;

public class InventoryManagementSystem {
    static class Item {
        int itemId;
        String itemName;
        String category;
        int quantity;
        double price;

        Item(int itemId, String itemName, String category, int quantity, double price) {
            this.itemId = itemId;
            this.itemName = itemName;
            this.category = category;
            this.quantity = quantity;
            this.price = price;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Item> items = new ArrayList<Item>();
        int choice;

        System.out.println("Inventory Management System");

        do {
            System.out.println();
            System.out.println("1. Add Item");
            System.out.println("2. View All Items");
            System.out.println("3. Search Item");
            System.out.println("4. Update Item");
            System.out.println("5. Restock Item");
            System.out.println("6. Sell Item");
            System.out.println("7. Delete Item");
            System.out.println("8. View Low Stock Items");
            System.out.println("9. Exit");

            choice = readInt(sc, "Enter your choice: ");

            switch (choice) {
                case 1:
                    addItem(sc, items);
                    break;
                case 2:
                    viewItems(items);
                    break;
                case 3:
                    searchItem(sc, items);
                    break;
                case 4:
                    updateItem(sc, items);
                    break;
                case 5:
                    restockItem(sc, items);
                    break;
                case 6:
                    sellItem(sc, items);
                    break;
                case 7:
                    deleteItem(sc, items);
                    break;
                case 8:
                    viewLowStockItems(items);
                    break;
                case 9:
                    System.out.println("Exiting inventory management system.");
                    break;
                default:
                    System.out.println("Invalid choice. Please select between 1 and 9.");
            }
        } while (choice != 9);

        sc.close();
    }

    private static void addItem(Scanner sc, ArrayList<Item> items) {
        int itemId = readInt(sc, "Enter item ID: ");

        if (findItem(items, itemId) != null) {
            System.out.println("Item with this ID already exists.");
            return;
        }

        String itemName = readNonEmptyString(sc, "Enter item name: ");
        String category = readNonEmptyString(sc, "Enter category: ");
        int quantity = readInt(sc, "Enter quantity: ");
        double price = readDouble(sc, "Enter price: ");

        if (quantity < 0) {
            System.out.println("Quantity cannot be negative.");
            return;
        }

        if (price < 0) {
            System.out.println("Price cannot be negative.");
            return;
        }

        items.add(new Item(itemId, itemName, category, quantity, price));
        System.out.println("Item added successfully.");
    }

    private static void viewItems(ArrayList<Item> items) {
        if (items.isEmpty()) {
            System.out.println("No items available in inventory.");
            return;
        }

        System.out.printf(
            "%-10s %-22s %-18s %-12s %-12s%n",
            "Item ID",
            "Item Name",
            "Category",
            "Quantity",
            "Price"
        );

        for (Item item : items) {
            System.out.printf(
                "%-10d %-22s %-18s %-12d %-12.2f%n",
                item.itemId,
                item.itemName,
                item.category,
                item.quantity,
                item.price
            );
        }
    }

    private static void searchItem(Scanner sc, ArrayList<Item> items) {
        int itemId = readInt(sc, "Enter item ID to search: ");
        Item item = findItem(items, itemId);

        if (item == null) {
            System.out.println("Item not found.");
            return;
        }

        printItemDetails(item);
    }

    private static void updateItem(Scanner sc, ArrayList<Item> items) {
        int itemId = readInt(sc, "Enter item ID to update: ");
        Item item = findItem(items, itemId);

        if (item == null) {
            System.out.println("Item not found.");
            return;
        }

        String itemName = readNonEmptyString(sc, "Enter new item name: ");
        String category = readNonEmptyString(sc, "Enter new category: ");
        int quantity = readInt(sc, "Enter new quantity: ");
        double price = readDouble(sc, "Enter new price: ");

        if (quantity < 0) {
            System.out.println("Quantity cannot be negative.");
            return;
        }

        if (price < 0) {
            System.out.println("Price cannot be negative.");
            return;
        }

        item.itemName = itemName;
        item.category = category;
        item.quantity = quantity;
        item.price = price;
        System.out.println("Item updated successfully.");
    }

    private static void restockItem(Scanner sc, ArrayList<Item> items) {
        int itemId = readInt(sc, "Enter item ID to restock: ");
        Item item = findItem(items, itemId);

        if (item == null) {
            System.out.println("Item not found.");
            return;
        }

        int quantityToAdd = readInt(sc, "Enter quantity to add: ");

        if (quantityToAdd <= 0) {
            System.out.println("Restock quantity must be greater than zero.");
            return;
        }

        item.quantity += quantityToAdd;
        System.out.println("Item restocked successfully. Updated quantity: " + item.quantity);
    }

    private static void sellItem(Scanner sc, ArrayList<Item> items) {
        int itemId = readInt(sc, "Enter item ID to sell: ");
        Item item = findItem(items, itemId);

        if (item == null) {
            System.out.println("Item not found.");
            return;
        }

        int quantityToSell = readInt(sc, "Enter quantity to sell: ");

        if (quantityToSell <= 0) {
            System.out.println("Sale quantity must be greater than zero.");
            return;
        }

        if (quantityToSell > item.quantity) {
            System.out.println("Insufficient stock available.");
            return;
        }

        item.quantity -= quantityToSell;
        System.out.println("Item sold successfully. Updated quantity: " + item.quantity);
    }

    private static void deleteItem(Scanner sc, ArrayList<Item> items) {
        int itemId = readInt(sc, "Enter item ID to delete: ");
        Item item = findItem(items, itemId);

        if (item == null) {
            System.out.println("Item not found.");
            return;
        }

        items.remove(item);
        System.out.println("Item deleted successfully.");
    }

    private static void viewLowStockItems(ArrayList<Item> items) {
        if (items.isEmpty()) {
            System.out.println("No items available in inventory.");
            return;
        }

        boolean lowStockFound = false;

        for (Item item : items) {
            if (item.quantity <= 5) {
                if (!lowStockFound) {
                    System.out.printf(
                        "%-10s %-22s %-18s %-12s %-12s%n",
                        "Item ID",
                        "Item Name",
                        "Category",
                        "Quantity",
                        "Price"
                    );
                    lowStockFound = true;
                }

                System.out.printf(
                    "%-10d %-22s %-18s %-12d %-12.2f%n",
                    item.itemId,
                    item.itemName,
                    item.category,
                    item.quantity,
                    item.price
                );
            }
        }

        if (!lowStockFound) {
            System.out.println("No low stock items found.");
        }
    }

    private static void printItemDetails(Item item) {
        System.out.println("Item found:");
        System.out.println("Item ID    : " + item.itemId);
        System.out.println("Item Name  : " + item.itemName);
        System.out.println("Category   : " + item.category);
        System.out.println("Quantity   : " + item.quantity);
        System.out.printf("Price      : %.2f%n", item.price);
    }

    private static Item findItem(ArrayList<Item> items, int itemId) {
        for (Item item : items) {
            if (item.itemId == itemId) {
                return item;
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
