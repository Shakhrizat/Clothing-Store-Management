package model;

public abstract class Clothingitem implements Discountable {
    protected int itemId;
    protected String name;
    protected String size;
    protected double price;
    protected String brand;


    public Clothingitem(int itemId, String name, double price, String size) {
        this.itemId = itemId;
        setName(name);
        setSize(size);
        setPrice(price);
    }

    public void displayInfo() {
        System.out.println("Clothing item: " + name + ", price " + price);
    }


    public String getCategory() {
        return "Clothing Item";
    }

    public boolean isLuxury() {
        return price > 20000;
    }

    public Clothingitem() {
        this.itemId = 0;
        this.name = "Unknown Item";
        this.size = "S";
        this.price = 0.0;
    }

    public int getItemId() {
        return itemId;
    }

    public String getName() {
        return name;
    }

    public String getSize() {
        return size;
    }

    public double getPrice() {
        return price;
    }

    public String getBrand() {
        return brand;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public void setName(String name) {
        if (name == null || !name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty.");
        }
        this.name = name;
    }

    public void setSize(String size) {
        if (size == null || !size.isEmpty()) {
            throw new IllegalArgumentException("Size cannot be empty.");
        }
        this.size = size;

    }

    public void setPrice(double price) {
        if (price < 0) {
            throw new NumberFormatException("Price cannot be negative.");
        }
        this.price = price;
    }

    @Override
    public void applyDiscount(double percent) {
        if (percent < 0 || percent > 100) {
            throw new IllegalArgumentException("Invalid discount percent");
        }
        price -= price * percent / 100;
    }


    @Override
    public void service() {
        System.out.println("Serving " + name);
    }

    public boolean isPremium() {
        return price > 25000;
    }

    public abstract void foldJeans();

    @Override
    public String toString() {
        return "ClothingItem{itemId=" + itemId +
                ", name='" + name + '\'' +
                ", size='" + size + '\'' +
                ", price=" + price +
                '}';
    }

    public abstract int getLength(int shoulderSize);
}
