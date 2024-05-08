package ku.cs.controllers;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import ku.cs.models.Customer;
import ku.cs.models.CustomerList;
import ku.cs.services.Datasource;
import ku.cs.services.CustomerListFileDatasource;
import ku.cs.services.FXRouter;

import java.io.IOException;

public class CustomersTableController {

    @FXML private TableView<Customer> customersTableView;

    private CustomerList customerList;

    private Datasource<CustomerList> datasource;

    @FXML
    public void initialize() {
        datasource = new CustomerListFileDatasource("data", "customer-list.csv");
        customerList = datasource.readData();
        showTable(customerList);

        customersTableView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Customer>() {
            @Override
            public void changed(ObservableValue observable, Customer oldValue, Customer newValue) {
                if (newValue != null) {
                    try {
                        // FXRouter.goTo สามารถส่งข้อมูลไปยังหน้าที่ต้องการได้ โดยกำหนดเป็น parameter ที่สอง
                        FXRouter.goTo("customer-balance", newValue.getId());
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });
    }

    private void showTable(CustomerList customerList) {
        // กำหนด column ให้มี title ว่า ID และใช้ค่าจาก attribute id ของ object Student
        TableColumn<Customer, String> idColumn = new TableColumn<>("Customer ID");
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));

        // กำหนด column ให้มี title ว่า Name และใช้ค่าจาก attribute name ของ object Student
        TableColumn<Customer, String> nameColumn = new TableColumn<>("Name");
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        // กำหนด column ให้มี title ว่า Score และใช้ค่าจาก attribute score ของ object Student
        TableColumn<Customer, Double> balanceColumn = new TableColumn<>("Balance");
        balanceColumn.setCellValueFactory(new PropertyValueFactory<>("balance"));

        // ล้าง column เดิมทั้งหมดที่มีอยู่ใน table แล้วเพิ่ม column ใหม่
        customersTableView.getColumns().clear();
        customersTableView.getColumns().add(idColumn);
        customersTableView.getColumns().add(nameColumn);
        customersTableView.getColumns().add(balanceColumn);

        customersTableView.getItems().clear();

        // ใส่ข้อมูล Student ทั้งหมดจาก studentList ไปแสดงใน TableView
        for (Customer customer: customerList.getCustomers()) {
            customersTableView.getItems().add(customer);
        }
    }

    @FXML
    public void onBackButtonClick() {
        try {
            FXRouter.goTo("admin");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
