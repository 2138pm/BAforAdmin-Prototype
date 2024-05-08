package ku.cs.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import ku.cs.models.Customer;
import ku.cs.models.CustomerList;
import ku.cs.services.Datasource;
import ku.cs.services.FXRouter;
import ku.cs.services.CustomerListFileDatasource;

import java.io.IOException;


public class CustomerBalanceController {
    @FXML private Label nameLabel;
    @FXML private Label idLabel;
    @FXML private Label balanceLabel;
    @FXML private Label errorLabel;
    @FXML private TextField balanceTextField;

    private Datasource<CustomerList> datasource;
    private CustomerList customerList;
    private Customer customer;

    @FXML
    public void initialize() {
        datasource = new CustomerListFileDatasource("data", "customer-list.csv");
        customerList = datasource.readData();

        // รับข้อมูล studentId จากหน้าอื่น ผ่าน method FXRouter.getData()
        // โดยจำเป็นต้อง casting data type ให้ตรงกับหน้าที่ส่งข้อมูล
        String customerId = (String) FXRouter.getData();
        customer = customerList.findCustomerById(customerId);

        showCustomer(customer);

        errorLabel.setText("");
    }

    private void showCustomer(Customer customer) {
        nameLabel.setText(customer.getName());
        idLabel.setText(customer.getId());
        balanceLabel.setText("" + customer.getBalance());
    }

    @FXML
    public void handleGiveBalanceButton() {
        String balanceString = balanceTextField.getText().trim();
        if (balanceString.equals("")) {
            errorLabel.setText("balance is required");
            return;
        }
        try {
            double balance = Double.parseDouble(balanceString);
            if (balance < 0) {
                errorLabel.setText("balance must be positive number");
                return;
            }
            errorLabel.setText("");
            customerList.giveBalanceToId(customer.getId(), balance);
            balanceTextField.clear();
            datasource.writeData(customerList);
            showCustomer(customer);
        } catch (NumberFormatException e) {
            errorLabel.setText("score must be number");
        }
    }

    @FXML
    public void handleBackToCustomersTableButton() {
        try {
            FXRouter.goTo("customers-table");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
