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

    public void onRegisterButtonClick(ActionEvent event) {
        checkRegister();
    }


    private void checkRegister()  {
        Datasource<AdminList> datasource = new AdminListFileDatasource("data", "admin-list.csv");
        adminList = datasource.readData();

        errorLabel.setText("");
        String username = giveUsernameTextField.getText();
        String id = giveIdTextField.getText();
        String password = givePasswordTextField.getText();

        if (giveUsernameTextField.getText().isEmpty() || giveIdTextField.getText().isEmpty() || givePasswordTextField.getText().isEmpty())
        {
            errorLabel.setText("Please enter your data.");
            return;
        }

        if(adminList.isExists(username, id)){
            errorLabel.setText("The data has been used!");
            return;
        }

            adminList.addNewAdmin(username, id, password);
            datasource.writeData(adminList);
            onRegisterButtonClick();
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
            FXRouter.goTo("success");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
