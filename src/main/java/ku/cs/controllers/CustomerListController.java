package ku.cs.controllers;

import ku.cs.services.CustomerListFileDatasource;
import ku.cs.services.Datasource;
import ku.cs.services.FXRouter;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import ku.cs.models.Customer;
import ku.cs.models.CustomerList;
import ku.cs.services.CustomerHardCodeDatasource;

import java.io.IOException;

public class CustomerListController {
    @FXML private ListView<Customer> customerListView;
    @FXML private Label idLabel;
    @FXML private Label nameLabel;
    @FXML private Label balanceLabel;

    @FXML private Label errorLabel;
    @FXML private TextField giveBalanceTextField;

    private CustomerList customerList;
    private Customer selectedCustomer;
    private Datasource<CustomerList> datasource;

    @FXML
    public void initialize() {
        errorLabel.setText("");
        clearCustomerInfo();
        //CustomerHardCodeDatasource datasource = new CustomerHardCodeDatasource();
        //Datasource<CustomerList> datasource = new CustomerListFileDatasource("data", "customer-list.csv");
        datasource = new CustomerListFileDatasource("data", "customer-list.csv");
        customerList = datasource.readData();
        showList(customerList);
        customerListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Customer>() {
            @Override
            public void changed(ObservableValue<? extends Customer> observable, Customer oldValue, Customer newValue) {
                if (newValue == null) {
                    clearCustomerInfo();
                    selectedCustomer = null;
                } else {
                    showCustomerInfo(newValue);
                    selectedCustomer = newValue;
                }
            }
        });
    }

    private void showList(CustomerList customerList) {
        customerListView.getItems().clear();
        customerListView.getItems().addAll(customerList.getCustomers());
    }
    private void showCustomerInfo(Customer customer) {
        idLabel.setText(customer.getId());
        nameLabel.setText(customer.getName());
        balanceLabel.setText(String.format("%.2f", customer.getBalance()));
    }

    private void clearCustomerInfo() {
        idLabel.setText("");
        nameLabel.setText("");
        balanceLabel.setText("");
    }

    @FXML
    public void onBackButtonClick() {
        try {
            FXRouter.goTo("admin-list");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @FXML
    public void onGiveBalanceButtonClick() {
        if (selectedCustomer != null) {
            String balanceText = giveBalanceTextField.getText();
            String errorMessage = "";
            try {
                double balance = Double.parseDouble(balanceText);
                customerList.giveBalanceToId(selectedCustomer.getId(), balance);
                showCustomerInfo(selectedCustomer);
                datasource.writeData(customerList);
                showList(customerList);
            } catch (NumberFormatException e) {
                errorMessage = "Please insert number value";
                errorLabel.setText(errorMessage);
            } finally {
                if (errorMessage.equals("")) {
                    giveBalanceTextField.setText("");
                }
            }
        } else {
            giveBalanceTextField.setText("");
            errorLabel.setText("");
        }
    }

}
