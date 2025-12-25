public class Customer {
    private String fullName;
    private int id;
    private String email;
    private long phoneNum;
    private String homeAddress;


    public Customer(String fullName, int id, String email, long phoneNum, String homeAddress) {
        this.fullName = fullName;
        this.id = id;
        this.email = email;
        this.phoneNum = phoneNum;
        this.homeAddress = homeAddress;
    }
    public Customer() {
        this.id = 0;
        this.fullName = "Unknown Customer";
        this.email = "Unknown email";
        this.phoneNum = +70000000000L;
        this.homeAddress = "Unknown address";
    }
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(long phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getHomeAddress() {
        return homeAddress;
    }

    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }

    public void updateContactInfo(String newemail, long newphoneNumber) {
        this.email = newemail;
        this.phoneNum = newphoneNumber;
    }

    public void placeOrder(Order order) {
        System.out.println("Order placed by " + fullName);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "Full name='" + fullName + '\'' +
                ", id=" + id + '\'' +
                "Email=" + email + '\'' +
                "Phone number=" + phoneNum + '\'' +
                "Home address=" + homeAddress + '\'' +
                '}';
    }
}
