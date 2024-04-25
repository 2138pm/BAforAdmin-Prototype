package ku.cs.models;

public class Customer {
    private String id;
    private String name;
    private double balance;

    public Customer(String id, String name, double balance) {
        this.id = id;
        this.name = name;
        this.balance = balance;
    }

    public void changeName(String name) {
        if (!name.trim().equals("")) {
            this.name = name.trim();
        }
    }

    public void addBalance(double balance) {
        if (balance > 0) {
            this.balance += balance;
        }
    }
    public String tier()
    {
        return "A";
    }

    public boolean isId(String id) {
        return this.id.equals(id);
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

    @Override
    public String toString() {
        return "{" +
                "id: '" + id + '\'' +
                ", name: '" + name + '\'' +
                ", balance: " + balance +
                '}';
    }
}
