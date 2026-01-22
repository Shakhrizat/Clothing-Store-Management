package model;

public class Jeans extends Clothingitem{
    protected int waistSize;
    protected String fit;

    public Jeans(int itemId, String name, double price, String size, int waistSize) {
        super(itemId, name, price, size);
        this.waistSize = waistSize;
    }

    public void setFit(String fit) {
        if (fit == null || fit.trim().isEmpty()) {
            throw new IllegalArgumentException("Fit should be slim/regular/large.");
        }
        this.fit = fit.trim();
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
