package Menu;

import model.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class MenuManager implements Menu {

    protected ArrayList<Clothingitem> items;
    protected ArrayList<Customer> customers;
    protected ArrayList<Order> orders;
    protected Scanner scanner;

    public MenuManager() {
        this.items = new ArrayList<>();
        this.customers = new ArrayList<>();
        this.orders = new ArrayList<>();
        this.scanner = new Scanner(System.in);

        items.add(new Jeans(2, "Classic jeans", "S", 25000, 45));
        items.add(new Top(2, "Crop Top", "S", 8000, 33));
        customers.add(new Customer("Aigul Aigul",1 , "aigul90@mail.ru", 87029784852L, "Bokenbay Batyr 3"));
        orders.add(new Order(1001, LocalDate.of(2026, 1, 20), 38000, "Pending"));
    }

    private void viewAllItems() {
        if (items.isEmpty()) {
            System.out.println("No clothing items found.");
            return;
        }
        for (Clothingitem item : items) {
            System.out.println(item);
        }
    }

    private void viewAllCustomers() {
        if (customers.isEmpty()) {
            System.out.println("No customers found.");
            return;
        }
        for (Customer customer : customers) {
            System.out.println(customer);
        }
    }

    private void viewAllOrders(){
        if (orders.isEmpty()){
            System.out.println("No orders found.");
            return;
        }
        for (Order order : orders ){
            System.out.println(order);
        }
    }

    private void demonstratePolymorphism() {
        System.out.println("\n--- Polymorphism Demo ---");
        for (Clothingitem item : items) {
            item.displayInfo();
        }
    }

    @Override
    public void displayMenu() {
        System.out.println("\n==============================");
        System.out.println("\n=== CLOTHING STORE SYSTEM ===");
        System.out.println("\n==============================");
        System.out.println("1. Add Clothing Item");
        System.out.println("2. Find item by ID");
        System.out.println("3. View All Clothing Items");
        System.out.println("4. View Customers");
        System.out.println("5. View Orders");
        System.out.println("6. Polymorphism Demo");
        System.out.println("0. Exit");
        System.out.print("Please enter your choice: ");
    }

    @Override
    public void run() {
        boolean running = true;

        while (running) {
            displayMenu();
            try {
                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        addClothingItem();
                        break;
                    case 2:
                        viewAllItems();
                        break;
                    case 3:
                        demonstratePolymorphism();
                        break;
                    case 0:
                        running = false;
                        System.out.println("Goodbye!\uD83C\uDF1F");
                        break;
                    default:
                        System.out.println("Invalid choice!");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                scanner.nextLine();
            }
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
            double price = Double.parseDouble(scanner.nextLine());

            Clothingitem item = new Jeans(id, name, size, price, 30);
            item.applyDiscount(10);

            items.add(item);
            System.out.println("Item added successfully!✅");

        } catch (NumberFormatException e) {
            System.out.println("Invalid number format!");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    private Clothingitem findById(int id) {
        for (Clothingitem item : items) {
            if (item.getItemId() == id) return item;
        }
        throw new IllegalArgumentException("Item with ID " + id + " not found.");
    }
}
