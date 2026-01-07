import java.time.LocalDate;


public class Order {
    private int orderId;
    private LocalDate orderDate;
    private int totalAmount;
    private boolean isReady;
    private String status;

    public Order(int orderId, LocalDate orderDate, int totalAmount, String status) {
        this.orderId = orderId;
        setOrderDate(orderDate);
        setTotalAmount(totalAmount);
        setStatus(status);
    }
    public Order() {
        this.orderId = 0;
        this.orderDate = LocalDate.now();
        this.totalAmount = 0;
        this.status = "Is not ready";
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
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
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
