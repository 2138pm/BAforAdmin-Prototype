package ku.cs.services;

import ku.cs.models.CustomerList;
public class CustomerHardCodeDatasource {
    public CustomerList readData() {
        CustomerList list = new CustomerList();
        list.addNewCustomer("6410400001", "First",0);
        list.addNewCustomer("6410400002", "Second",0);
        list.addNewCustomer("6410400003", "Third",0);
        list.addNewCustomer("6410400004", "Fourth", 0);
        return list;
    }
}
