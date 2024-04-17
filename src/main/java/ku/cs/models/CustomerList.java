package ku.cs.models;

import java.util.ArrayList;
public class CustomerList {
    private ArrayList<Customer> customers;

    public CustomerList() {
        customers = new ArrayList<>();
    }

    public void addNewCustomer(String id, String name) {
        id = id.trim();
        name = name.trim();
        if (!id.equals("") && !name.equals("")) {
            Customer exist = findCustomerById(id);
            if (exist == null) {
                customers.add(new Customer(id.trim(), name.trim()));
            }
        }
    }

    public Customer findCustomerById(String id) {
        for (Customer customer : customers) {
            if (customer.isId(id)) {
                return customer;
            }
        }
        return null;
    }

    public void giveBalanceToId(String id, double balance) {
        Customer exist = findCustomerById(id);
        if (exist != null) {
            exist.addBalance(balance);
        }
    }

    public String viewTierOfId(String id) {
        Customer exist = findCustomerById(id);
        if (exist != null) {
            return exist.tier();
        }
        return null;
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }
}
