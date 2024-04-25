package ku.cs.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import ku.cs.models.Admin;
import ku.cs.models.AdminList;
import ku.cs.services.AdminListFileDatasource;
import ku.cs.services.Datasource;
import ku.cs.services.FXRouter;

import java.io.IOException;

public class AdminRegisterController {
    private Datasource<AdminList> datasource;

    @FXML private Label errorLabel;
    @FXML private TextField giveUsernameTextField;
    @FXML private TextField giveIdTextField;
    @FXML private TextField givePasswordTextField;
    private AdminList adminList;

    public void onRegisterButtonClick(ActionEvent event) throws IOException {
        checkRegister();
    }


    private void checkRegister() throws IOException {
        Datasource<AdminList> datasource = new AdminListFileDatasource("data", "admin-list.csv");
        adminList = datasource.readData();

        errorLabel.setText("");
        String username = giveUsernameTextField.getText();
        String id = giveIdTextField.getText();
        String password = givePasswordTextField.getText();

        for (Admin admin : adminList.getAdmins()) {
            if (giveUsernameTextField.getText().isEmpty() || giveIdTextField.getText().isEmpty() || givePasswordTextField.getText().isEmpty())
            {
                errorLabel.setText("Please enter your data.");
            }
            else if (admin.getName().equals(username) || admin.getId().equals((id)) || admin.getPassword().equals(password) ) {
                errorLabel.setText("The data has been used!");
                break;
            }else {
                    adminList.addNewAdmin(username, id, password);
                    datasource.writeData(adminList);
                    onRegisterButtonClick();
                    return;
                }
        }
    }

    @FXML
    public void onBackButtonClick() {
        try {
            FXRouter.goTo("login");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    protected void onRegisterButtonClick() {
        try {
            FXRouter.goTo("admin-list");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
