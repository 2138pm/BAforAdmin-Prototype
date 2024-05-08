package ku.cs.controllers;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import ku.cs.services.Datasource;
import ku.cs.services.FXRouter;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import ku.cs.models.Admin;
import ku.cs.models.AdminList;
import ku.cs.services.AdminHardCodeDatasource;
import ku.cs.models.AdminList;

import java.io.IOException;
import ku.cs.services.AdminListFileDatasource;
import ku.cs.services.exceptions.AuthenticationFailedException;

public class LoginController {

    @FXML private Button login;
    @FXML private Label errorLabel;
    @FXML private TextField giveUsernameTextField;
    @FXML private PasswordField givePasswordTextField;

    private AdminList adminList;


    public void onLoginButtonClick(ActionEvent event) throws IOException {
        checkLogin();
    }


    private void checkLogin() throws IOException {
        Datasource<AdminList> datasource = new AdminListFileDatasource("data", "admin-list.csv");
        adminList = datasource.readData();

        errorLabel.setText("");
        String username = giveUsernameTextField.getText();
        String password = givePasswordTextField.getText();

        if(giveUsernameTextField.getText().isEmpty() && givePasswordTextField.getText().isEmpty()) {
            errorLabel.setText("Please enter your data.");
            return;
        }

        try {
            Admin admin = adminList.authen(username, password);
            FXRouter.goTo("admin", admin);
        } catch (AuthenticationFailedException e){
            errorLabel.setText(e.getMessage());
        }catch (IOException e) {
            throw new RuntimeException(e);
        }
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
    protected void onLoginButtonClick() {
        try {
            FXRouter.goTo("admin");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    public void onRegisterButtonClick() {
        try {
            FXRouter.goTo("register");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}

