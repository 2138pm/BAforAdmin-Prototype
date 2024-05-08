package ku.cs.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import ku.cs.models.Admin;
import ku.cs.models.AdminList;
import ku.cs.services.AdminListFileDatasource;
import ku.cs.services.Datasource;
import ku.cs.services.FXRouter;

import java.io.IOException;


public class AdminController {

    @FXML private Label nameLabel;
    @FXML private Label idLabel;
    @FXML private Label passwordLabel;

    private Datasource<AdminList> datasource;

    @FXML
    public void initialize() {
        datasource = new AdminListFileDatasource("data", "admin-list.csv");
        //Admin admin = new Admin("August Youth", "6610450170", "CS38");
        Admin admin = (Admin) FXRouter.getData();
        showAdminName(admin);
        showAdminId(admin);
        //showAdminPw(admin);
    }


    private void showAdminName(Admin admin) {
        nameLabel.setText(admin.getName());
    }
    private void showAdminId(Admin admin) {
        idLabel.setText(admin.getId());
    }
    //private void showAdminPw(Admin admin) { passwordLabel.setText(admin.getPassword());}

    @FXML
    public void onBackButtonClick() {
        try {
            FXRouter.goTo("login");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    protected void onContinueButtonClick() {
        try {
            FXRouter.goTo("customers-table");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
