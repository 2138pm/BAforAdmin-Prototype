package ku.cs.controllers;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import ku.cs.models.Admin;
import ku.cs.models.AdminList;
import ku.cs.services.AdminHardCodeDatasource;
import ku.cs.services.AdminListFileDatasource;
import ku.cs.services.Datasource;
import ku.cs.services.FXRouter;

import java.io.IOException;

public class AdminListController {
    @FXML
    private ListView<Admin> adminListView;
    @FXML private Label idLabel;
    @FXML private Label nameLabel;
    @FXML private Label passwordLabel;



    private AdminList adminList;
    private Admin selectedAdmin;
    private Datasource<AdminList> datasource;
    @FXML
    public void initialize() {

        clearAdminInfo();
        //AdminHardCodeDatasource datasource = new AdminHardCodeDatasource();
        //Datasource<AdminList> datasource = new AdminListFileDatasource("data", "admin-list.csv");
        datasource = new AdminListFileDatasource("data", "admin-list.csv");
        adminList = datasource.readData();
        showList(adminList);
        adminListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Admin>() {
            @Override
            public void changed(ObservableValue<? extends Admin> observable, Admin oldValue, Admin newValue) {
                if (newValue == null) {
                    clearAdminInfo();
                    selectedAdmin = null;
                } else {
                    showAdminInfo(newValue);
                    selectedAdmin = newValue;
                }
            }
        });
    }

    private void showList(AdminList adminList) {
        adminListView.getItems().clear();
        adminListView.getItems().addAll(adminList.getAdmins());
    }
    private void showAdminInfo(Admin admin) {
        nameLabel.setText(admin.getName());
        idLabel.setText(admin.getId());
        passwordLabel.setText(admin.getPassword());
    }

    private void clearAdminInfo() {
        nameLabel.setText("");
        idLabel.setText("");
        passwordLabel.setText("");
    }

    @FXML
    public void onBackButtonClick() {
        try {
            FXRouter.goTo("hello");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    protected void onContinueButtonClick() {
        try {
            FXRouter.goTo("customer-list");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

