package ku.cs.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import ku.cs.models.Customer;
public class CustomerController {
    @FXML
    private Label nameLabel;

    @FXML
    public void initialize() {
        Customer customer = new Customer("6410400001", "Tony Stark");
        showStudent(customer);
    }

    private void showStudent(Customer customer) {
        nameLabel.setText(customer.getName());
    }
}
