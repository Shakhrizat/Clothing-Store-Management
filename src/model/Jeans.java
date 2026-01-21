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

    public void setWaistSize(int waistSize) {
        this.waistSize = waistSize;
    }

    public boolean isWaistLarge() {
        return waistSize >= 80;
    }

    public void foldJeans() {
        System.out.println("Jeans " + name + " are folded.");
    }

    public int getWaistsize() {
        this.waistSize=waistSize;
        return waistSize;
    }
    @Override
    public String toString(){
        return super.toString()+"| Waist size: "+waistSize;
    }
}
