package model;

public class Employee {
    private int employeeId;
    private String employeeName;
    private String position;
    private int salary;
    private int hireDate;

    public Employee(int employeeId, String employeeName, String position, int salary, int hireDate) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.position = position;
        this.salary = salary;
        this.hireDate = hireDate;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        if (employeeName == null || employeeName.trim().isEmpty()) {
            throw new IllegalArgumentException("Employee name cannot be empty");
        }
        this.employeeName = employeeName;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        if (position == null || position.trim().isEmpty()) {
            throw new IllegalArgumentException("Employee position cannot be empty");
        }
        this.position = employeeName;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        if (salary < 0) {
            throw new NumberFormatException("Salary cannot be negative.");
        }
        this.salary = salary;
    }

    public int getHireDate() {
        return hireDate;
    }

    public void setHireDate(int hireDate) {
        this.hireDate = hireDate;
    }

    public void updateSalary(int newSalary) {
        salary = newSalary;
    }

    public void processOrder(Order order) {
        order.isReady();
        System.out.println("Order processed by " + employeeName);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "Full name='" + employeeName + '\'' +
                "Id=" + employeeId + '\'' +
                "Posiion=" + position + '\'' +
                "Salary=" + salary + '\'' +
                "Hire date=" + hireDate + '\'' +
                '}';
    }
}
