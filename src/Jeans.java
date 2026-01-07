public class Jeans extends Clothingitem{
    private int waistSize;

    public Jeans(int itemId, String name, String size, double price, int waistSize) {
        super(itemId, name, price, size);
        this.waistSize = waistSize;
    }

    @Override
    public void displayInfo() {
        System.out.println("Jeans: " + name + ", waist: " + waistSize + ", price: " + price);
    }

    @Override
    public String getCategory() {
        return "Jeans";
    }

    public void setWaistSize(int waistSize) {
        this.waistSize = waistSize;
    }

    public boolean isLargeWaist() {
        return waistSize >= 34;
    }

    public void ironPants() {
        System.out.println("Jeans " + name + " are ironed.");
    }

    public int getWaistsize() {
        this.waistSize=waistSize;
        return waistSize;
    }
}
