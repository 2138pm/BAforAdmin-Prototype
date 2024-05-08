package ku.cs.controllers;

import javafx.fxml.FXML;
import ku.cs.services.FXRouter;

import java.io.IOException;

public class SuccessRegisterController {

    @FXML
    public void onBackToLoginButtonClick() {
        try {
            FXRouter.goTo("login");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    protected void onSeeCustomerTableButtonClick() {
        try {
            FXRouter.goTo("customers-table");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
