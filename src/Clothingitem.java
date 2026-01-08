public class Clothingitem {
    protected int itemId;
    protected String name;
    protected String size;
    protected double price;
    protected String brand;
    protected int discount;


    public Clothingitem(int itemId, String name, double price, String size ) {
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

    public Clothingitem (){
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
        if (name != null && !name.trim().isEmpty()) {
            this.name = name;
        } else {
            System.out.println("Warning: Name cannot be empty!");
        }
    }
    public void setSize(String size) {
        if (size != null && !size.isEmpty()) {
            this.size = size;
        } else {
            this.size = "Warning! Choose your size!";
        }
    }

    public void setPrice(double price) {
        if (price >= 0) {
            this.price = price;
        } else {
            System.out.println("Price cannot be negative. Set to 0.");
            this.price = 0;
        }
    }

    public void applyDiscount(double percentage) {
        price = price * (1 - percentage / 100);
    }

    public boolean isPremium(){
        return price > 25000;
    }

    @Override
    public String toString() {
        return "ClothingItem{itemId=" + itemId +
                ", name='" + name + '\'' +
                ", size='" + size + '\'' +
                ", price=" + price +
                '}';
    }

}