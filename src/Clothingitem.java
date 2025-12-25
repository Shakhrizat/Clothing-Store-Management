
public class Clothingitem {
    private int itemid;
    private String name;
    private double price;
    private String size;
    private boolean isInStock;

    public Clothingitem(int itemid, String name, int price, String size, boolean IsinStock) {
        this.itemid = itemid;
        this.name=name;
        this.price=price;
        this.size=size;
    }
    public Clothingitem() {
        this.itemid = 0;
        this.name = "Unknown Item";
        this.size = "S";
        this.price = 0;
    }

    public int getItemid() {
        return itemid;
    }

    public void setItemid(int itemid) {
        this.itemid = itemid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public void setInStock(boolean isInStock) {
        this.isInStock = isInStock;
    }
    public String getStockStatus() {
        if (isInStock) {
            return "In stock";
        } else {
            return "Not in stock";
        }
    }
    boolean inStock = true;

    public double applyDiscount(double percentage) {
        price =  price * (1 - (percentage / 100));
        return price;
}
    public boolean isLuxury(double price){
        return price>50000;
    }

    @Override
    public String toString() {
        return "ClothingItem{itemId=" + itemid +
                ", name='" + name + '\'' +
                ", size='" + size + '\'' +
                ", price=" + price +
                '}';

    }
}
