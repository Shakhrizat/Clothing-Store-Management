package model;

public class Customer {
    protected String fullName;
    protected int id;
    protected String email;
    protected long phoneNum;
    protected String homeAddress;


    public Customer(String fullName, int id, String email, long phoneNum, String homeAddress) {
        this.id = id;
        setFullName(fullName);
        setEmail(email);
        setHomeAddress();
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
        if (fullName != null && !fullName.trim().isEmpty()) {
            this.fullName = fullName;
        } else {
            this.fullName = "Customer, please enter your name.";
        }
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
        if (email != null && !email.trim().isEmpty()) {
            this.email = email;
        } else {
            this.email = "Customer, please enter your email.";
        }
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

    public void setHomeAddress() {
        if (homeAddress != null && !homeAddress.trim().isEmpty()) {
            this.homeAddress = homeAddress;
        } else {
            this.homeAddress = "Customer, please enter your address.";
        }
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
