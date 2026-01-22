package model;

public class Top extends Clothingitem{
    protected int shoulderSize;

    public Top(int itemId, String name, String size, double price, int shoulderSize) {
        super(itemId, name, price, size);
        this.shoulderSize = shoulderSize;
    }
    @Override
    public void displayInfo() {
        System.out.println(
                "Top: " + name +
                        ", size: " + size +
                        ", length: " + shoulderSize +
                        ", price: " + price
        );
    }

    @Override
    public String getCategory() {
        return "Top";
    }

    @Override
    public void foldJeans() {
        System.out.println("Top " + name + " is folded.");
    }

    @Override
    public int getLength(int shoulderSize) {
        return shoulderSize;
    }
}
