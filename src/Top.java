public class Top extends Clothingitem{
    private int shoulderSize;

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
    public int getLength() {
        return shoulderSize;
    }
}

