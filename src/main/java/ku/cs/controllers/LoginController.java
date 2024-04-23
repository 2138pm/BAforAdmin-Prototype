package ku.cs.controllers;

import javafx.event.ActionEvent;
import javafx.scene.control.*;
import ku.cs.services.FXRouter;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import ku.cs.models.Admin;
import ku.cs.models.AdminList;
import ku.cs.services.AdminHardCodeDatasource;

import java.io.IOException;
import java.util.ArrayList;

public class LoginController {

    @FXML private Button login;
    @FXML private Label errorLabel;
    @FXML private TextField giveUsernameTextField;
    @FXML private PasswordField givePasswordTextField;


    private Admin admin;
    private AdminList adminlist;

//    private String username = admin.getId();
//    private String password = admin.getPassword();


    public void onLoginButtonClick(ActionEvent event) throws IOException {

        checkLogin();

    }

    private void checkLogin() throws IOException {
        errorLabel.setText("");
        if(giveUsernameTextField.getText().equals("August") && givePasswordTextField.getText().equals("CS38")) {
            errorLabel.setText("Success!");

            onLoginButtonClick();
        }

        else if(giveUsernameTextField.getText().isEmpty() && givePasswordTextField.getText().isEmpty()) {
            errorLabel.setText("Please enter your data.");
        }


        else {
            errorLabel.setText("Wrong username or password!");
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
            FXRouter.goTo("admin-list");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}


//เหลือสร้างหน้าAdmin List Info
