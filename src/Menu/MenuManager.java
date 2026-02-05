package Menu;

import database.ClothingItemDAO;
import model.Clothingitem;
import model.Jeans;
import model.Top;

import java.util.List;
import java.util.Scanner;

public class MenuManager implements Menu {

    private final ClothingItemDAO itemDAO;
    private final Scanner scanner;

    public MenuManager() {
        this.itemDAO = new ClothingItemDAO();
        this.scanner = new Scanner(System.in);
    }

    private void viewAllItems() {
        List<Clothingitem> items = itemDAO.getAllItems();

        if (items.isEmpty()) {
            System.out.println("No items found.");
            return;
        }

        System.out.println("\n--- ALL CLOTHING ITEMS ---");
        for (Clothingitem item : items) {
            System.out.println(item);
        }
    }

    private void addClothingItem() {
        try {
            System.out.print("ID: ");
            int id = Integer.parseInt(scanner.nextLine());

            System.out.print("Name: ");
            String name = scanner.nextLine();

            System.out.print("Size: ");
            String size = scanner.nextLine();

            System.out.print("Price: ");
            int price = Integer.parseInt(scanner.nextLine());

            Clothingitem item = new Jeans(id, name, price, size, 30);

            itemDAO.insertClothingItem(item);
            System.out.println("Item saved to database!");

        } catch (NumberFormatException e) {
            System.out.println("Invalid number format.");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void updateClothingItem() {
        try {
            System.out.print("Enter item ID to update: ");
            int id = Integer.parseInt(scanner.nextLine());

            System.out.print("New name: ");
            String name = scanner.nextLine();

            System.out.print("New size: ");
            String size = scanner.nextLine();

            System.out.print("New price: ");
            int price = Integer.parseInt(scanner.nextLine());

            boolean updated = itemDAO.updateItem(id, name, price, size);

            if (updated) System.out.println("Item updated successfully!");
            else System.out.println("Item not found.");

        } catch (NumberFormatException e) {
            System.out.println("Invalid number format.");
        }
    }

    private void deleteClothingItem() {
        try {
            System.out.print("Enter item ID to delete: ");
            int id = Integer.parseInt(scanner.nextLine());

            Clothingitem item = itemDAO.getItemById(id);
            if (item == null) {
                System.out.println("⚠ No item found with ID: " + id);
                return;
            }

            System.out.println("Item to delete: " + item);

            System.out.print("Are you sure? (yes/no): ");
            String confirm = scanner.nextLine();

            if (confirm.equalsIgnoreCase("yes")) {
                boolean deleted = itemDAO.deleteItem(id);
                if (deleted) System.out.println("Item deleted successfully.");
                else System.out.println("Deletion failed.");
            } else {
                System.out.println("Deletion cancelled.");
            }

        } catch (NumberFormatException e) {
            System.out.println("Invalid number format.");
        }
    }

    private void searchItemByName() {
        System.out.print("Enter name keyword: ");
        String keyword = scanner.nextLine();

        List<Clothingitem> results = itemDAO.searchByName(keyword);

        if (results.isEmpty()) {
            System.out.println("No matching items found.");
            return;
        }

        System.out.println("\n--- SEARCH RESULTS ---");
        for (Clothingitem item : results) {
            System.out.println(item);
        }
    }

    private void searchItemByMaxPrice() {

        try {
            System.out.print("Enter maximum price: ");
            int maxPrice = Integer.parseInt(scanner.nextLine());

            List<Clothingitem> results = itemDAO.searchByMaxPrice(maxPrice);

            if (results.isEmpty()) {
                System.out.println("No items found under that price.");
            } else {
                System.out.println("\nItems under " + maxPrice + ":");

                for (Clothingitem item : results) {
                    System.out.println(item);
                }
            }

        } catch (NumberFormatException e) {
            System.out.println("Invalid number. Please enter a valid price.");
        }
    }


    private void demonstratePolymorphism() {
        System.out.println("\n--- Polymorphism Demo ---");

        Clothingitem demoItem1 = new Jeans(0, "Black Jeans", 15000, "S", 32);
        Clothingitem demoItem2 = new Top(0, "Blue top", "S", 18000, 45);

        demoItem1.displayInfo();
        demoItem2.displayInfo();
    }

    @Override
    public void displayMenu() {
        System.out.println("\n===  CLOTHING STORE SYSTEM  ===");
        System.out.println("1. Add Clothing Item");
        System.out.println("2. View All Clothing Items");
        System.out.println("3. Update Clothing Item");
        System.out.println("4. Delete clothing item.");
        System.out.println("\n--- SEARCH AND FILTER ---");
        System.out.println("5. Search item by name.");
        System.out.println("6. Search item by price range.");
        System.out.println("7. Filter items by minimum price.");
        System.out.println("\n--- DEMO AND OTHER ---");
        System.out.println("8. Polymorphism Demo");
        System.out.println("0. Exit");
        System.out.print("Please enter your choice: ");
    }

    @Override
    public void run() {
        boolean running = true;

        while (running) {
            displayMenu();
            try {
                int choice = Integer.parseInt(scanner.nextLine());

                switch (choice) {
                    case 1:
                        addClothingItem();
                        break;
                    case 2:
                        viewAllItems();
                        break;
                    case 3:
                        updateClothingItem();
                        break;
                    case 4:
                        deleteClothingItem();
                        break;
                    case 5:
                        searchItemByName();
                        break;
                    case 6:
                        searchByPriceRange();
                        break;
                    case 7:
                        filterByMinPrice();
                        break;
                    case 8:
                        demonstratePolymorphism();
                        break;
                    case 0: {
                        running = false;
                        System.out.println("Goodbye!");
                        break;
                    }
                    default:
                        System.out.println("Invalid input.");
                }

            } catch (NumberFormatException e) {
                System.out.println("Invalid number format, pls try again.");
            }
        }
    }

    private void searchByPriceRange() {
        try {
            System.out.println("Enter minimum price: ");
            double min = Double.parseDouble(scanner.nextLine());

            System.out.println("Enter maximum price: ");
            double max = Double.parseDouble(scanner.nextLine());

            itemDAO.searchByPriceRange(min, max);
        } catch (NumberFormatException e) {
            System.out.println("Invalid number format");
        }
    }

    private void filterByMinPrice(){
        try {
            System.out.println("Please enter minimum price: ");
            double min = Double.parseDouble(scanner.nextLine());
            itemDAO.filterByMinPrice(min);
        }catch (NumberFormatException e){
            System.out.println("invalid number format, please try again.");
        }
    }
}
