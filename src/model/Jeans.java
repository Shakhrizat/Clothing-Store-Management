package model;

public class Jeans extends Clothingitem{
    private int waistSize;

    public Jeans(int itemId, String name, String size, double price, int waistSize) {
        super(itemId, name, price, size);
        this.waistSize = waistSize;
    }
    @Override
    public void displayInfo() {
        System.out.println("Jeans: " + name +
                ", size: " + size +
                ", waist: " + waistSize
                + ", price: " + price);
    }
    @Override
    public String getCategory() {
        return "Jeans";
    }

    public boolean isWaistLarge() {
        return waistSize >= 80;
    }

    @Override
    public void foldJeans() {
        System.out.println("Jeans " + name + " are folded.");
    }

    @Override
    public String toString(){
        return super.toString()+"| Waist size: "+waistSize;
    }

    @Override
    public int getLength(int shoulderSize) {
        return 0;
    }
}
