import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Clothing STore Management System ===");




        Clothingitem Clothing1 = new Clothingitem();


        Clothingitem Clothing2 = new Clothingitem(1,"Skirt", 8000, "S", true);
        Clothingitem Clothing3 = new Clothingitem(2, "Pants", 11000, "M", false);
        System.out.println(Clothing2);
        System.out.println(Clothing3);

        Customer customer1 = new Customer("Arai", 1, "arai.elu@gmail.com", 87029764732L, "Mukhanov");
        Customer customer2 = new Customer("Baurzhan Maksat", 2, "beka345@mail.ru", 87774925038L, "Mangilik EL 83A");

        Order order1 = new Order(1, LocalDate.of(2025, 10, 21), 5000, false);
        Order order2 = new Order();

        Brand brand1 = new Brand(430, "Bershka", "United States", 4.8);
        Brand brand2 = new Brand(245, "Мое", "Russia", 3.6);

        System.out.println("--- CLOTHING ITEMS ---");
        System.out.println(Clothing1);
        System.out.println(Clothing2);
        System.out.println(Clothing3);
        System.out.println();

        System.out.println("--- CUSTOMERS ---");
        System.out.println(customer1);
        System.out.println(customer2);
        System.out.println();

        System.out.println("--- ORDER ---");
        System.out.println(order1);
        System.out.println(order2);

        System.out.println("--- BRANDS ---");
        System.out.println(brand1);
        System.out.println(brand2);

        System.out.println("--- GETTERS ---");
        System.out.println("Item1 size: " + Clothing1.getSize());
        System.out.println("Customer1 address: " + customer1.getHomeAddress());
        System.out.println();

        System.out.println("--- SETTERS ---");
        Clothing2.setName("Shirt");
        Clothing2.setSize("S");
        Clothing2.setPrice(5000);
        Clothing2.setInStock(true);
        Clothing3.setPrice(18000);
        brand2.setBrandName("Intertop");
        System.out.println(Clothing1);
        System.out.println();

        System.out.println("--- METHODS ---");
        Clothing2.applyDiscount(50.45);
        System.out.println("Discounted item1 price: " + Clothing2.getPrice());
        System.out.println("Item1 is lux: " + Clothing2.isLuxury(Clothing1.getPrice()));
        System.out.println("Is your money worth it: " + brand1.isFavorable(brand1.getRating()));

        customer1.updateContactInfo("araika780@icloud.com", 870293641325L);

        System.out.println("Info about brand: " + brand2.getBrandDetails());

        System.out.println("=== Program Complete ===");

    }
}