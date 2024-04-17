package ku.cs.services;

import ku.cs.models.CustomerList;
public class CustomerHardCodeDatasource {
    public CustomerList readData() {
        CustomerList list = new CustomerList();
        list.addNewCustomer("6410400001", "First");
        list.addNewCustomer("6410400002", "Second");
        list.addNewCustomer("6410400003", "Third");
        list.addNewCustomer("6410400004", "Fourth");
        return list;
    }
}
