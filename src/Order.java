import java.time.LocalDate;


public class Order {
    private int orderId;
    private LocalDate orderDate;
    private int totalAmount;
    private boolean isReady;

    public Order(int orderId, LocalDate orderDate, int totalAmount, boolean isReady) {
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.totalAmount = totalAmount;
        this.isReady = isReady;
    }
    public Order() {
        this.orderId = 0;
        this.orderDate = LocalDate.now();
        this.totalAmount = 0;
        this.isReady = true;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public int getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(int totalAmount) {
        this.totalAmount = totalAmount;
    }

    public boolean isReady() {
        return isReady;
    }

    public void setReady(boolean ready) {
        isReady = ready;
    }

    @Override
    public String toString() {
        return "Order{" +
                "Order ID=" + orderId + '\'' +
                "Date=" + orderDate + '\'' +
                "Total amount=" + totalAmount + '\'' +
                "Status for delivery=" + isReady + '\'' +
                '}';
    }
}
