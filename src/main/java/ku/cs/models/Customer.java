package ku.cs.models;

public class Customer {
    private String id;
    private String name;
    private double balance;

    public Customer(String id, String name) {
        this.id = id;
        this.name = name;
        balance = 0;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getBalance() {
        return balance;
    }
}
