package model;

public class Top extends Clothingitem{
    protected int shoulderSize;
    protected String material;

    public Top(int itemId, String name, String size, double price, int shoulderSize) {
        super(itemId, name, price, size);
        this.shoulderSize = shoulderSize;
    }

    public void setMaterial(String material) {
        if (material == null || material.trim().isEmpty()) throw new IllegalArgumentException("Please, choose material.");
        this.material = material.trim();
    }

    public String getMaterial() {
        return material;
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
