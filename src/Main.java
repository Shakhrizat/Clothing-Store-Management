import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<Clothingitem> items = new ArrayList<>();
    private static ArrayList<Customer> customers = new ArrayList<>();
    private static ArrayList<Order> orders = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("=== Clothing Store Management System ===");
        System.out.println("This system will help you order any clothing items and organize your orders!");
        System.out.println("It will allow adding new products, updating inventory, and viewing sales.");
        System.out.println("\n=== Clothing Store Management System ===\n");

        items.add(new Clothingitem(1,"Skirt", 8000, "S"));
        items.add(new Clothingitem(2, "Pants", 11000, "M"));
        items.add(new Jeans(3, "Baggy jeans", "S", 20000, 66));
        items.add(new Top(4, "Crop Top", "M", 5000,  34));

        customers.add(new Customer("Arai", 1, "arai.elu@gmail.com", 87029764732L, "Mukhanov"));
        customers.add(new Customer("Baurzhan Maksat", 2, "beka345@mail.ru", 87774925038L, "Mangilik EL 83A"));

        orders.add(new Order(1, LocalDate.of(2025, 10, 21), 5000, "Is ready to pick up"));
        orders.add(new Order(2, LocalDate.of(2026, 1, 3), 50000, "Pending"));

        boolean running = true;

        while (running) {
            displayMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    addClothingitem();
                    break;
                case 2:
                    viewAllItems();
                    break;
                case 3:
                    addCustomer();
                    break;
                case 4:
                    viewAllCustomers();
                    break;
                case 5:
                    addOrder();
                    break;
                case 6:
                    viewAllOrders();
                    break;
                case 7:
                    demonstratePolymorphism();
                    break;
                case 8:
                    showJeansDetails();
                    break;
                case 0:
                    running = false;
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice!");
            }

            if (running) {
                System.out.println("\nPress Enter to continue...");
                scanner.nextLine();
            }
        }

        scanner.close();
    }

    private static void showJeansDetails() {
        System.out.println("\n=== JEANS DETAILS (instanceof demo)===");

        for ( Clothingitem item : items){
            if ( item instanceof Jeans) {
                Jeans jeans = (Jeans) item;
                System.out.println(
                        "Jeans name: " + jeans.getName() + ", length: " + jeans.getWaistsize()
                );
            }
        }
    }
    private static void demonstratePolymorphism(){
        System.out.println("\n=== POLYMORPHISM DEMO ===");

        for ( Clothingitem item : items){
            item.displayInfo();
        }
    }
    private static void displayMenu() {
        System.out.println("\n=== CLOTHING STORE SYSTEM ===");
        System.out.println("1. Add Clothing Item");
        System.out.println("2. View All Clothing Items");
        System.out.println("3. Add Customer");
        System.out.println("4. View All Customers");
        System.out.println("5. Add Order");
        System.out.println("6. View All Orders");
        System.out.println("7. Show polymorphism demo");
        System.out.println("8. Show jeans details (instanceof demo)");
        System.out.println("0. Exit");
        System.out.print("Enter your choice: ");
    }
    private static void addClothingitem() {
        System.out.println("\n--- Add Clothing Item ---");

        System.out.print("Enter item ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter name: ");
        String name = scanner.nextLine();

        System.out.print("Enter size: ");
        String size = scanner.nextLine();

        System.out.print("Enter price: ");
        double price = scanner.nextDouble();
        scanner.nextLine();

        Clothingitem item = new Clothingitem(id, name, price, size);
        items.add(item);

        System.out.println("Clothing item added successfully!");
    }
    private static void viewAllItems() {
        System.out.println("\n--- All Clothing Items ---");

        if (items.isEmpty()) {
            System.out.println("No clothing items found.");
            return;
        }

        for (Clothingitem item : items) {
            System.out.println(item);
        }
    }
    private static void addCustomer() {
        System.out.println("\n--- Add Customer ---");

        System.out.print("Enter customer ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter name: ");
        String name = scanner.nextLine();

        System.out.print("Enter email: ");
        String email = scanner.nextLine();

        System.out.print("Enter your phone number: ");
        long phoneNum = scanner.nextLong();

        System.out.print("Enter your address: ");
        String homeAddress = scanner.nextLine();
        scanner.nextLine();

        Customer customer = new Customer(name, id, email, phoneNum, homeAddress);
        customers.add(customer);

        System.out.println("Customer added successfully!");
    }

    private static void viewAllCustomers() {
        System.out.println("\n--- All Customers ---");

        if (customers.isEmpty()) {
            System.out.println("No customers found.");
            return;
        }

        for (Customer customer : customers) {
            System.out.println(customer);
        }
    }

    private static void addOrder() {
        System.out.println("\n--- Add Order ---");

        System.out.print("Enter order ID: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Enter total amount: ");
        int amount = scanner.nextInt();

        System.out.print("Enter the date ordered: ");
        LocalDate date = LocalDate.parse(scanner.next());
        scanner.nextLine();

        System.out.print("Enter status (Is not ready to pick up/Is ready to pick up): ");
        String status = scanner.nextLine();

        Order order = new Order(id, date, amount, status);
        orders.add(order);

        System.out.println("Order added successfully!");
    }


    private static void viewAllOrders() {
        System.out.println("\n--- All Orders ---");

        if (orders.isEmpty()) {
            System.out.println("No orders found.");
            return;
        }

        for (Order order : orders) {
            System.out.println(order);
        }
    }

}

