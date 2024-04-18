package ku.cs.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import ku.cs.models.Admin;
import ku.cs.models.Customer;
import ku.cs.services.FXRouter;

import java.io.IOException;

public class AdminController {

    @FXML private Label nameLabel;
    @FXML private Label idLabel;

    @FXML
    public void initialize() {
        Admin admin = new Admin("August Youth", "6610450170");
        showAdminName(admin);
        showAdminId(admin);
    }

    private void showAdminName(Admin admin) {
        nameLabel.setText(admin.getName());
    }
    private void showAdminId(Admin admin) {
        idLabel.setText(admin.getId());
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
